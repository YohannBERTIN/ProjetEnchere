package fr.eni.projet.bll;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.User;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UserDAO;


public class RegisterForm {

	public static final String PSEUDO_FIELD = "userPseudo";
	public static final String LAST_NAME_FIELD = "userLastName";
	public static final String FIRST_NAME_FIELD = "userFirstName";
	public static final String EMAIL_FIELD = "userEmail";
	public static final String PHONE_FIELD = "userPhone";
	public static final String STREET_FIELD = "userStreet";
	public static final String ZIPCODE_FIELD = "userZip";
	public static final String CITY_FIELD = "userCity";
	public static final String PASSWORD_FIELD = "userPassword";
	public static final String CONFIRMPWD_FIELD = "userConfirmation";
	
	private UserDAO userDAO;
	
	private String result;
	private Map<String, String> errors = new HashMap<String,String>();
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public User registerUser(HttpServletRequest request) throws BusinessException {
		
		this.userDAO = DAOFactory.getUserDAO();
		
		String pseudo = getFieldValue(request, PSEUDO_FIELD);
		String lastName = getFieldValue(request, LAST_NAME_FIELD);
		String firstName = getFieldValue(request, FIRST_NAME_FIELD);
		String email = getFieldValue(request, EMAIL_FIELD);
		String phone = getFieldValue(request, PHONE_FIELD);
		String street = getFieldValue(request, STREET_FIELD);
		String zip = getFieldValue(request, ZIPCODE_FIELD);
		String city = getFieldValue(request, CITY_FIELD);
		String password = getFieldValue(request, PASSWORD_FIELD);
		String confirmPassword = getFieldValue(request, CONFIRMPWD_FIELD);
		
		User user = new User();
		try {
			pseudoValidation(pseudo);
		} catch (Exception e) {
			setError( PSEUDO_FIELD, e.getMessage());
		}
		user.setPseudo(pseudo);
		
		try {
			emailValidation(email);
		} catch (Exception e) {
			setError( EMAIL_FIELD, e.getMessage());
		}
		
		user.setEmail(email);
		
		try {
			passwordValidation(password, confirmPassword);
		} catch (Exception e) {
			setError(PASSWORD_FIELD, e.getMessage());
			setError(CONFIRMPWD_FIELD, null);
		}
		
		user.setPassword(password);
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhone(phone);
		user.setStreet(street);
		user.setZip(zip);
		user.setCity(city);
		user.setPassword(confirmPassword);
		user.setCredit(0);
		user.setAdministrator(0);
		
		
		if (errors.isEmpty()) {
			
			this.userDAO.insert(user);
			result = "Succès de l'inscription";
			System.out.println("Utilisateur crée : pseudo = " + pseudo + " nom = " + lastName + " prénom = " + firstName + " email = " + email + " téléphone = " + phone + " rue = " + street + " code postal = " + zip + " ville = " + city + " mdp = " + password );
			
		} else {
			
			result = "Echec de l'inscription";
			
		}
		
		return user;
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
			
			User userBDD = this.userDAO.search(pseudo);
			
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
	private void emailValidation(String email) throws Exception {
		
		if (email != null) {
			
			User userBDD = this.userDAO.searchEmail(email);
			
			if (!email.contains("@")) {
				
				throw new Exception ("Merci de saisir une adresse email valide !");
				
			} else if (email.equals(userBDD.getEmail())) {
				
				throw new Exception ("Ce mail est déjà utiliser, veuillez en choisir un autre !");
			}
		} else {
			
			throw new Exception ("Merci de saisir une adresse email !");
			
		}
	}
	
	/**
	 * Verification for detecting if two password are the same.
	 * @param password
	 * @param confirmPassword
	 * @throws Exception
	 */
	private void passwordValidation(String password, String confirmPassword) throws Exception {
		
		if (password != null && confirmPassword != null) {
			
			if (!password.equals(confirmPassword)) {
				throw new Exception("Les mots de passe entrés sont différents, Merci de les saisir à nouveau !");
			}
			
		} else {
			
			throw new Exception("Merci de saisir et confirmer votre mot de passe");
			
		}
	}
	
	private void setError(String fieldName, String message) {
		errors.put(fieldName, message);
	}
}
