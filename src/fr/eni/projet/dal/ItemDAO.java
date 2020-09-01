package fr.eni.projet.dal;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Item;
import fr.eni.projet.bo.Pickup;

public interface ItemDAO {

	void insert(Item item, Pickup pickup) throws BusinessException;
	
	void delete(Item item) throws BusinessException;
}
