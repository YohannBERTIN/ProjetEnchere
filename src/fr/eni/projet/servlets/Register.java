package fr.eni.projet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet gérant la création d'un client/utilisateur
 * 
 * Servlet implementation class ServletCréationUtilisateur
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récupération des données saisies, envoyés en tant que paramètres
				// de la requête GET générée à la validation du formaulaire
				String pseudo = request.getParameter("userPseudo");
				String nom = request.getParameter("userLastName");
				String prenom = request.getParameter("userFirstName");
				String email = request.getParameter("userEmail");
				String telephone = request.getParameter("userPhone");
				String rue = request.getParameter("userStreet");
				String codePostal = request.getParameter("userZip");
				String ville = request.getParameter("userCity");
				String mdp = request.getParameter("userPassword");
				String confirmMdp = request.getParameter("userConfirmation");
				
				try {
					// !!! Probleme vérification saisie mdp !!!
					validationEmail(email);
					validationMotDePasse(mdp, confirmMdp);
					validationSaisie(pseudo, nom, prenom, email, rue, codePostal, ville, mdp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
								
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index_login.jsp").forward(request, response);
	}
	
	private void validationEmail(String email) throws Exception {
		if(email != null && email.trim().length() != 0) {
			
			//if(!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")); { 
				//throw new Exception("Merci de saisir une adresse e-mail valide");
			//} 
		} else {
			throw new Exception("Merci de saisir une adresse mail.");
		}
	}
	
	private void validationMotDePasse(String mdp, String confirmation) throws Exception{
		if(mdp != null && mdp.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
			if(!mdp.equals(confirmation)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} else if(mdp.trim().length() < 8) {
				throw new Exception("Les mots de passes doivent contenir au moins 8 caractères.");
			} else {
				throw new Exception("Merci de saisir et de confirmer votre mot de passe");
			}
		}
		
	}
	
	private void validationSaisie(String pseudo, String nom, String prenom, String email, String rue, String codePostal, String ville, String mdp) throws Exception {
		
		String message;
		
		if(nom != null && nom.trim().length() < 3) {
			message = "Le nom d'utilisateur ou Pseudo doit contenir au moins 3 caractères";
		} else if (nom.trim().isEmpty() || prenom.trim().isEmpty() || rue.trim().isEmpty() || ville.trim().isEmpty()) {
				message = "Attention - Tous les champs obligatoires doivent être remplis pour pouvoir créer votre profil utilisateur !";
		} else {
			message = "Votre profil utilisateur a été créé avec succès !";
		}
	}

}
