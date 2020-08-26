package fr.eni.projet.bll;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.projet.bo.User;

public class LoginForm {

	public static final String PSEUDO_FIELD = "userPseudo";
	public static final String PASSWORD_FIELD = "userPassword";
	
	private String result;
	private Map<String, String> errors = new HashMap<String,String>();
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public User loginUser(HttpServletRequest request) {
		
		String pseudo = getFieldValue(request, PSEUDO_FIELD);
		String password = getFieldValue(request, PASSWORD_FIELD);
		
		User user = new User();
		
		try {
			pseudoValidation(pseudo);
		} catch (Exception e) {
			setError(PSEUDO_FIELD, e.getMessage());
		}
		
		user.setPseudo(pseudo);
		
		try {
			passwordValidation(password);
		} catch (Exception e) {
			setError(PASSWORD_FIELD, e.getMessage());	
		}
		
		user.setPassword(password);
		
		if(errors.isEmpty()) {
			result = "Succès de la connexion";
		} else {
			result = "Echec de la connexion";
		}
		
		return user;
	}
	
	private static String getFieldValue(HttpServletRequest request, String fieldName) {
		String value = request.getParameter(fieldName);
		
		if (value == null || value.trim().length() == 0) {
			
			return null;
			
		} else {
			
			return value.trim();
			
		}
	}
	
	private void pseudoValidation(String pseudo) throws Exception {
		if(pseudo != null) {
			if(!pseudo.equals("admin")) {
				throw new Exception("Utilisateur non reconnu !");
			} 
		} else {
			throw new Exception("Merci de saisir votre pseudo !");
		}
	}
	
	private void passwordValidation(String password) throws Exception {
		if(password != null) {
			if(!password.equals("admin")) {
				throw new Exception("Mot de passe erroné");
			} 
		} else {
			throw new Exception("Merci de saisir votre mot de passe");
		}
	}
	
	private void setError(String fieldName, String message) {
		errors.put(fieldName, message);
	}
}

