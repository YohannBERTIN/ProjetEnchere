package fr.eni.projet.bll;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.User;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UserDAO;

public class ModifyProfilForm {
	
	public static final String PARAM_USERID = "userId";
	
	public static final String PSEUDO_FIELD = "userPseudo";
	public static final String LAST_NAME_FIELD = "userLastName";
	public static final String FIRST_NAME_FIELD = "userFirstName";
	public static final String EMAIL_FIELD = "userEmail";
	public static final String PHONE_FIELD = "userPhone";
	public static final String STREET_FIELD = "userStreet";
	public static final String ZIPCODE_FIELD = "userZip";
	public static final String CITY_FIELD = "userCity";
	
	public static final String PASSWORD_FIELD = "userPassword";
	public static final String NEW_PASSWORD_FIELD = "newUserPassword";
	public static final String CONFIRMPWD_FIELD = "userConfirmation";
	
	public static final String BDD_ID = "no_utilisateur";
	public static final String BDD_MAIL = "email";
	public static final String BDD_PSEUDO = "pseudo";
	
	private UserDAO userDAO;
	
	private String result;
	private Map<String, String> errors = new HashMap<String,String>();
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	// [x] récupérer son ID depuis la session via la request
	// [x] récupérer l'user avec cet ID dans la base de données
	// [x] je dois modifier l'user avec les info du formulaire qui sont dans la request
	// [ ] je dois renvoyer l'user mis à jour au serveur sql
	public User modifyUser(HttpServletRequest request) throws BusinessException {
		
		this.userDAO = DAOFactory.getUserDAO();
		
		// récupérer son ID depuis la session via la request
		String userID = getFieldValue(request, PARAM_USERID);
		
		User bddUser = new User();
		
		// récupérer l'user avec cet ID dans la base de données
		bddUser = this.userDAO.search(BDD_ID, userID);
		
		// je dois modifier l'user avec les info du formulaire qui sont dans la request
		
		String pseudo = getFieldValue(request, PSEUDO_FIELD);
		String lastName = getFieldValue(request, LAST_NAME_FIELD);
		String firstName = getFieldValue(request, FIRST_NAME_FIELD);
		String email = getFieldValue(request, EMAIL_FIELD);
		String phone = getFieldValue(request, PHONE_FIELD);
		String street = getFieldValue(request, STREET_FIELD);
		String zip = getFieldValue(request, ZIPCODE_FIELD);
		String city = getFieldValue(request, CITY_FIELD);
		String password = getFieldValue(request, PASSWORD_FIELD);
		String newPassword = getFieldValue(request, NEW_PASSWORD_FIELD);
		String confirmPassword = getFieldValue(request, CONFIRMPWD_FIELD);
		
		if (PSEUDO_FIELD != null) {
			try {
				pseudoValidation(pseudo);
			} catch (Exception e) {
				setError( PSEUDO_FIELD, e.getMessage());
			}
		}
		
		if (EMAIL_FIELD != null) {
			try {
				emailValidation(email, bddUser);
			} catch (Exception e) {
				setError( EMAIL_FIELD, e.getMessage());
			}
		}
		
		if (PASSWORD_FIELD != null || NEW_PASSWORD_FIELD != null || CONFIRMPWD_FIELD != null) {
			try {
				passwordValidation(password, newPassword, confirmPassword, bddUser);
			} catch (Exception e) {
				setError(PASSWORD_FIELD, e.getMessage());
				setError(CONFIRMPWD_FIELD, null);
			}
		}
		
		if (errors.isEmpty()) {
			
			bddUser.setPseudo(pseudo);
			bddUser.setPassword(password);
			bddUser.setEmail(email);
			
			if (FIRST_NAME_FIELD != null ) {
				bddUser.setFirstName(firstName);
			}
			if (LAST_NAME_FIELD != null ) {
				bddUser.setLastName(lastName);	
			}
			if (PHONE_FIELD != null ) {
				bddUser.setPhone(phone);
			}
			if (STREET_FIELD != null ) {
				bddUser.setStreet(street);
			}
			if (ZIPCODE_FIELD != null ) {
				bddUser.setZip(zip);
			}
			if (CITY_FIELD != null ) {
				bddUser.setCity(city);
			}
			
			// envoyer la modif à la base de données
			this.userDAO.updateUser(bddUser);
			
			result = "Succès de la modification !";
			System.out.println("Utilisateur mis à jour : pseudo = " + pseudo + " nom = " + lastName + " prénom = " + firstName + " email = " + email + " téléphone = " + phone + " rue = " + street + " code postal = " + zip + " ville = " + city + " mdp = " + password );
			
		} else {
			result = "Echec de la modification !";
		}
		return bddUser;
	}
	
	/**
	 * Verification for detecting null value on getParameter
	 * @param request
	 * @param fieldName
	 * @return
	 */
	private static String getFieldValue(HttpServletRequest request, String fieldName) {
		String value = request.getParameter(fieldName);
		
		if (value == null || value.trim().length() == 0) {
			
			return null;
			
		} else {
			
			return value.trim();
			
		}
	}
	
	/**
	 * Verification for detecting if it is in database.
	 * @param pseudo
	 * @throws Exception
	 */
	private void pseudoValidation(String pseudo) throws Exception {
		
		if (pseudo != null) {
			
			User userBDD = this.userDAO.search(BDD_PSEUDO, pseudo);
			
			if (pseudo.equals(userBDD.getPseudo())) {
				
				throw new Exception ("Ce pseudo est déjà pris, veuillez en choisir un autre !");
				
			}
		} else {
			
			throw new Exception ("Merci de saisir un pseudo !");
			
		}
	}
	
	/**
	 * Verification for detecting if it is in database.
	 * @param email
	 * @throws Exception
	 */
	private void emailValidation(String email, User bddUser) throws Exception {
		if (email != null) {
			
			if (!email.contains("@")) {
				
				throw new Exception ("Merci de saisir une adresse email valide !");
				
			} else if (!email.equals(bddUser.getEmail())) {
				
				User validUser = this.userDAO.validMail(BDD_MAIL, email, BDD_ID, bddUser.getUserId());
					
					if (email.equals(validUser.getEmail())) {
					
						throw new Exception ("Ce mail est déjà utiliser, veuillez en choisir un autre !");
				}
			}
		} 
	}
	
	/**
	 * Verification for detecting if two password are the same.
	 * @param password
	 * @param confirmPassword
	 * @throws Exception
	 */
	private void passwordValidation(String password, String newPassword, String confirmPassword, User bddUser) throws Exception {
		// recup user dans bdd
		// comparer les deux mdp
		// comparer le new mdp avec la comfirmation
		
		if (newPassword != null && confirmPassword != null) { 
			if(password != null) {
				if (!password.equals(bddUser.getPassword())) {
					throw new Exception("Le mot de passe actuel est erroné !");
				} else if(!newPassword.equals(confirmPassword)) {
					throw new Exception("La confirmation du nouveau mot de passe est invalide !");
				}
			} else {
				throw new Exception("Merci de saisir le mot de passe actuel !");
			}
		} // fin du test	
	}
	
	private void setError(String fieldName, String message) {
		errors.put(fieldName, message);
	}

}
