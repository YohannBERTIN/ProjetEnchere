package fr.eni.projet.dal;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.User;

public interface UserDAO {
	public void insert(User user) throws BusinessException;

}
