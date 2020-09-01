package fr.eni.projet.dal;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.User;

public interface UserDAO {
	
	/**
	 * Add user on SQL database
	 * @param user = User type object
	 * @throws BusinessException
	 */
	void insert(User user) throws BusinessException;
	
	User search(String column, String colValue) throws BusinessException;
	
	User validMail(String column1, String colValue1, String column2, Long colValue2) throws BusinessException;
	
	void updateUser(User user) throws BusinessException;
	
	void deleteUser(String userID) throws BusinessException;
	

}
