package fr.eni.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bll.LoginForm;
import fr.eni.projet.bo.User;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String REDIRECTION = "/WEB-INF/jsp/index_login.jsp";
	public static final String ATT_USER = "user";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_USER = "sessionUser";
	public static final String VIEW = "/WEB-INF/jsp/login.jsp";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}
	
	/**
	 * Méthode doPost
	 * Cette méthode nous sert donc à:
	 * [X] Stocker les paramètres du formulaire présent dans jsp liés au attributs "login" et "mdp".
	 * [X] Vérifier si les paramètres récupérés des inputs jsp correspondent aux login et mdp ADMIN
	 * [ ] Créer la session . création de l'objet Utilisateur
	 * [X] Redirige vers la page qui affiche les enchères
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginForm form = new LoginForm();
		
		User user = null;
		try {
			user = form.loginUser(request);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		 //Créer la session
		HttpSession session = request.getSession();
		
		
		if(user != null) {
			
			session.setAttribute(ATT_SESSION_USER, user);
			
		} else {
			
			session.setAttribute(ATT_SESSION_USER, null);
			
		}
		
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_USER, user);
		
		 if (form.getErrors().isEmpty()) {
	        	
	        /* Transmission à la page JSP en charge de l'affichage des données */
			this.getServletContext().getRequestDispatcher(REDIRECTION).forward( request, response );
	        
	     } else {
	        	
	    	this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	        	        	
	     }
		
	}

}
