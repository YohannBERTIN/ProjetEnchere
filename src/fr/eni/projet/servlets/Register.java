package fr.eni.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bo.User;

/**
 * Servlet gérant la création d'un client/utilisateur
 * 
 * Servlet implementation class ServletCréationUtilisateur
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String PSEUDO = "userPseudo";
	public static final String LAST_NAME = "userLastName";
	public static final String FIRST_NAME = "userFirstName";
	public static final String EMAIL = "userEmail";
	public static final String PHONE = "userPhone";
	public static final String STREET = "userStreet";
	public static final String ZIPCODE = "userZip";
	public static final String CITY = "userCity";
	public static final String PASSWORD = "userPassword";
	public static final String CONFIRMPWD = "userConfirmation";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
//		rd.forward(request, response);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récupération des données saisies, envoyés en tant que paramètres
		// de la requête de type POST générée à la validation du formaulaire
		String pseudo = request.getParameter(PSEUDO);
		String nom = request.getParameter(LAST_NAME);
		String prenom = request.getParameter(FIRST_NAME);
		String email = request.getParameter(EMAIL);
		String telephone = request.getParameter(PHONE);
		String rue = request.getParameter(STREET);
		String codePostal = request.getParameter(ZIPCODE);
		String ville = request.getParameter(CITY);
		String mdp = request.getParameter(PASSWORD);
		String confirmMdp = request.getParameter(CONFIRMPWD);
		String message = "";
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if (pseudo.trim().isEmpty() || nom.trim().isEmpty() || prenom.trim().isEmpty() || email.trim().isEmpty() || rue.trim().isEmpty() || 
        	codePostal.trim().isEmpty() || ville.trim().isEmpty() || mdp.trim().isEmpty() || confirmMdp.trim().isEmpty()) {
            
        	message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.";
        	request.setAttribute( "message", message );
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
            
        } else if (email.contains("@")) {
        	
        	if (mdp.equals(confirmMdp)) {
        		
        		message = "Client créé avec succès !";
        		
        	} else {
            	
            	message = "Les mots de passe ne correspondent pas !";
            	request.setAttribute( "message", message );
            	this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
            	
        	}
        	
        } else {
        	
            message = "L'adresse email n'est pas une adresse valide";
            request.setAttribute( "message", message );
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
        	
        }
        
        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        User user = new User();
        user.setPseudo(pseudo);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setRue(rue);
        user.setCodePostal(codePostal);
        user.setVille(ville);
        user.setMotDePasse(mdp);
        

        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "user", user );
        request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/index_login.jsp" ).forward( request, response );
    }
	
}
