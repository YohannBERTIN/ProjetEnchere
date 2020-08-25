package fr.eni.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bo.Utilisateurs;

/**
 * Servlet gérant la création d'un client/utilisateur
 * 
 * Servlet implementation class ServletCréationUtilisateur
 */
@WebServlet("/register")
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des données saisies, envoyés en tant que paramètres
		// de la requête GET générée à la validation du formaulaire
		String pseudo = request.getParameter("#");
		String nom = request.getParameter("#");
		String prenom = request.getParameter("#");
		String email = request.getParameter("#");
		String telephone = request.getParameter("#");
		String rue = request.getParameter("#");
		String codePostal = request.getParameter("#");
		String ville = request.getParameter("#");
		String mdp = request.getParameter("#");
		String confirmMdp = request.getParameter("#");
		
		String message;
		
		/*
		 * Initialisation de message à afficher :
		 * Si un des champs obligatoires du formulaire n'est pas renseigné,
		 * alors on affiche un message d'erreur
		 * Sinon on affiche un message de succès
		 * 
		 */
		if (nom.trim().isEmpty() || rue.trim().isEmpty() || ville.trim().isEmpty() || telephone.trim().isEmpty()) {
			message = "Attention - Tous les champs obligatoires doivent être remplis.";
			response.sendRedirect("http://localhost:8080/ProjetEnchere/Register");
			
		} else {
			message = "Client créé avec succès !";
		}
		
		/*
		 * Création du bean Client et initialisation avec les données récupérées
		 */
		Utilisateurs user = new Utilisateurs(pseudo, nom, prenom, email, telephone, rue, codePostal, mdp, 0);
		
		/*
		 * Ajout du bean et du message à l'objet requête
		 */
		request.setAttribute("user", user);
		request.setAttribute("message", message);
		
		/*
		 * Transmission à la pageJSP en charge de l'affichage des données.
		 */
		this.getServletContext().getRequestDispatcher("/userProfile").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
