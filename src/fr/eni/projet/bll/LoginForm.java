package fr.eni.projet.bll;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.User;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UserDAO;

public class LoginForm {

	public static final String PSEUDO_FIELD = "userPseudo";
	public static final String PASSWORD_FIELD = "userPassword";
	
	private UserDAO userDAO;
	
	private String result;
	private Map<String, String> errors = new HashMap<String,String>();
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public User loginUser(HttpServletRequest request) throws BusinessException {
		
		String pseudo = getFieldValue(request, PSEUDO_FIELD);
		String password = getFieldValue(request, PASSWORD_FIELD);
		
		this.userDAO = DAOFactory.getUserDAO();
		
		User userBDD = this.userDAO.search(pseudo);
		User userLogin;
		
		try {
			pseudoValidation(pseudo, userBDD);
		} catch (Exception e) {
			setError(PSEUDO_FIELD, e.getMessage());
		}
		
		try {
			passwordValidation(password, userBDD);
		} catch (Exception e) {
			setError(PASSWORD_FIELD, e.getMessage());	
		}
		
		if(errors.isEmpty()) {
			
			result = "Succès de la connexion";
			userLogin = userBDD;
			
		} else {
			
			result = "Echec de la connexion";
			userLogin = null;
			
		}
		
		return userLogin;
	}
	
	private static String getFieldValue(HttpServletRequest request, String fieldName) {
		String value = request.getParameter(fieldName);
		
		if (value == null || value.trim().length() == 0) {
			
			return null;
			
		} else {
			
			return value.trim();
			
		}
	}
	
	private void pseudoValidation(String pseudo, User user) throws Exception {
		
		if(pseudo != null) {
	
			if(!pseudo.equals(user.getPseudo())) {
				
				throw new Exception("Utilisateur non reconnu !");
			} 
		} else {
			throw new Exception("Merci de saisir votre pseudo !");
		}
	}
	
	private void passwordValidation(String password, User user) throws Exception {
		
		if(password != null) {
			
			if(!password.equals(user.getPassword())) {
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

