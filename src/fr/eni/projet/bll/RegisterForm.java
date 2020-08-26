package fr.eni.projet.bll;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


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
	
	private String result;
	private Map<String, String> errors = new HashMap<String,String>();
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public User registerUser(HttpServletRequest request) {
		return user;
	}
}
