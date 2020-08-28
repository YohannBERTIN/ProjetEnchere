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
	
	User search(String userPseudo) throws BusinessException;
	
	User searchEmail(String userEmail) throws BusinessException;

}
