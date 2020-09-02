package fr.eni.projet.bll;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.projet.BusinessException;
import fr.eni.projet.dal.AuctionDAO;
import fr.eni.projet.dal.DAOFactory;

public class AuctionForm {

	AuctionDAO auctionDAO;
	
	private String result;
	private Map<String, String> errors = new HashMap<String, String>();
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public void addAuction(HttpServletRequest request) throws BusinessException {
		
		this.auctionDAO = DAOFactory.getAuctionDAO();
		
		
		
	}
}