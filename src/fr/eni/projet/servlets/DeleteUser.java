package fr.eni.projet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.View;
import fr.eni.projet.bll.DeleteUserForm;
import fr.eni.projet.bo.User;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/Delete_user")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_SESSION_USER = "sessionUser";
	public static final String ATT_FORM = "form";
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDeleteUser(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDeleteUser(request, response);
	}
	
	protected void doDeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		User userSession = (User) session.getAttribute(ATT_SESSION_USER);
		
		//test
		//System.out.println("L'user récup dans la session");
		//System.out.println(userSession);
		//System.out.println("------------");
		
		Long userID = userSession.getUserId();
		
		System.out.println("L'utilisateur no : " + userID + " va être supprimé de la base de données");
		
		DeleteUserForm form = new DeleteUserForm();
		
		try {
			form.deleteUser(userID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (form.getResult().isEmpty()) {
			session.invalidate();
			this.getServletContext().getRequestDispatcher(View.index).forward(request, response);	
		} else {
			request.setAttribute( ATT_FORM, form );
			this.getServletContext().getRequestDispatcher(View.modifyProfil).forward(request, response);
		}
	}
}
