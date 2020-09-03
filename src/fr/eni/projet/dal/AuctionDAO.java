package fr.eni.projet.dal;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Auctions;
import fr.eni.projet.bo.Pickup;
import fr.eni.projet.bo.Item;

public interface AuctionDAO {

	//Revoir cette méthode...
	void insert(Item soldItem, Auctions newAuction, Pickup pickup) throws BusinessException;
	
	void delete(Auctions auction) throws BusinessException;
	
}
