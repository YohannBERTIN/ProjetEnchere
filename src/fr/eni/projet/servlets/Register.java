package fr.eni.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bll.RegisterForm;
import fr.eni.projet.bo.User;

/**
 * Servlet gérant la création d'un client/utilisateur
 * 
 * Servlet implementation class ServletCréationUtilisateur
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_USER = "user";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_USER = "sessionUser";
	public static final String VIEW = "/WEB-INF/jsp/register.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RegisterForm form = new RegisterForm();
		HttpSession session = request.getSession();
		
		User user = null;
		try {
			user = form.registerUser(request);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		

        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, user );
        
        if (form.getErrors().isEmpty()) {
        	
        	/* Transmission à la page JSP en charge de l'affichage des données */
        	session.setAttribute(ATT_SESSION_USER, user);
        	this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/index_login.jsp" ).forward( request, response );
        
        } else {
        	
        	this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
        	        	
        }
        
       
    }
	
}
