package fr.eni.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.View;
import fr.eni.projet.bll.ItemForm;
import fr.eni.projet.bo.User;




/**
 * Servlet implementation class New_auction
 */
@WebServlet("/New_auction")
public class New_auction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_SESSION_USER = "sessionUser";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(View.newAuction).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		ItemForm form = new ItemForm();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(ATT_SESSION_USER);
		
		request.setAttribute("sessionUser", user);
		
		
		
		this.getServletContext().getRequestDispatcher(View.newAuction).forward(request, response);
		
		
	}

}
