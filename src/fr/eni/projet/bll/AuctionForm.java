package fr.eni.projet.bll;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.projet.BusinessException;
import fr.eni.projet.Form;
import fr.eni.projet.bo.Auctions;
import fr.eni.projet.bo.User;
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
		
		Auctions auction = new Auctions();
		User user = (User) request.getAttribute("AuctionerUser");
		
		auction.setMontantEnchere(Integer.parseInt(getFieldValue(request, Form.auctionAmount)));
		
		// revoir cette méthode ici et dans auctionDAO
		this.auctionDAO.insert(soldItem, newAuction, pickup);
		
		
	}
	
	private static String getFieldValue(HttpServletRequest request, String fieldName) {
		String value = request.getParameter(fieldName);
		
		if (value == null || value.trim().length() == 0) {
			
			return null;
			
		} else {
			
			return value.trim();
		}
	}
}