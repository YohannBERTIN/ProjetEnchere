package fr.eni.projet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String LOGIN_ADMIN = "admin";
	public static final String MDP_ADMIN = "admin";
	public static final String LOGIN = "login";
	public static final String MDP = "mdp";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
//		rd.forward(request, response);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		
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
		//Stocker les nomUtiliasateur et mdp dans des variables pour les insérer / comparer avec la base de donnée
		String loginInput = request.getParameter(LOGIN);
		String mdpInput = request.getParameter(MDP);
		String message = "";
		// Compare les entrées client avec les login et mdp Admin
		if(LOGIN_ADMIN.equals(loginInput) && MDP_ADMIN.equals(mdpInput)) {
			
			message = "Bienvenue cher(e) : " + LOGIN_ADMIN;
			request.setAttribute("message", message);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index_login.jsp").forward(request, response);
						
		} else {
			
			message = "Nom d'utilisateur ou Mot de passe inconnu. Merci de saisir une Nom d'utilisateur et/ou un mot de passe connu.";
			request.setAttribute("message", message);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			
		}
		
		//Comparer login et mdp avec la base de données
		
		
		
		// Créer la session
		//HttpSession session = request.getSession();
		
		
		
		
		//Redirection vers la jsp affichage enchère mode connecté
		//RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/index_login.jsp");
		//rd.forward(request, response);
		
		
	}

}
