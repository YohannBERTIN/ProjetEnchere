package fr.eni.projet.bll;

import java.util.HashMap;
import java.util.Map;

import fr.eni.projet.Bdd;
import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.User;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.UserDAO;

public class DeleteUserForm {
	
private UserDAO userDAO;
	
	private String result;
	private Map<String, String> errors = new HashMap<String,String>();
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public void deleteUser(Long userID) throws BusinessException {
		
		this.userDAO = DAOFactory.getUserDAO();
		
		userDAO.deleteUser(userID);
		
		User userTest = userDAO.search(Bdd.userID, String.valueOf(userID));
		
		//test
		System.out.println("DeleteUserForm");
		System.out.println(userTest);
		
		if (userID == userTest.getUserId()) {
			result = "La suppression à échouée !";
		}
	}
		

}
