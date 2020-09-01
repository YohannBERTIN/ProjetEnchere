package fr.eni.projet.dal;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bo.Auctions;
import fr.eni.projet.bo.Pickup;
import fr.eni.projet.bo.SoldItems;

public interface AuctionDAO {

	void insert(SoldItems soldItem, Auctions newAuction, Pickup pickup) throws BusinessException;
	
	void delete(Auctions auction) throws BusinessException;
	
}
