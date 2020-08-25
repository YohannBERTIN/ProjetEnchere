package fr.eni.projet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * Méthode doPost
	 * Cette méthode nous sert donc à:
	 * [X] Stocker les paramètres du formulaire présent dans jsp liés au attributs "login" et "mdp".
	 * [ ] Vérifier si les paramètres sont connus et corrects
	 * [ ] Créer la session . création de l'objet Utilisateur
	 * [X] Redirige vers la page qui affiche les enchères
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Stocker les nomUtiliasateur et mdp dans des variables pour les insérer / comparer avec la base de donnée
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		
		
		//Redirection vers la jsp affichage enchère mode connecté
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/encheresConnected.jsp");
		rd.forward(request, response);
				
	}

}
