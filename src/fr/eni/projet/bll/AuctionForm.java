package fr.eni.projet.bll;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.projet.BusinessException;
import fr.eni.projet.Form;
import fr.eni.projet.dal.AuctionDAO;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.servlets.Auction;

public class AuctionForm {

	public static final String ITEM_FIELD = "auctionName";
	public static final String DESCRIPTION_FIELD = "auctionDescription";
	public static final String CATEGORY_FIELD = "auctionCategory";
	public static final String PHOTO_FIELD = "auctionPhoto";
	public static final String START_PRICE_FIELD = "auctionStartPrice";
	public static final String START_DATE_FIELD = "auctionStartDate";
	public static final String END_DATE_FIELD = "auctionEndDate";
	
	//public static final String BDD_ID = "no_utilisateur";
	//public static final String BDD_ITEM_ID = "no_article";
	
	private AuctionDAO auctionDAO;
	
	private String result;
	private Map<String, String> errors = new HashMap<String, String>();
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public Auction addAuction(HttpServletRequest request) throws BusinessException {
		
		this.auctionDAO = DAOFactory.getAuctionDAO();
		
		String title = getFieldValue(request, Form.auctionTitle);
		String description = getFieldValue(request, Form.auctionDescription);
		String category = getFieldValue(request, Form.auctionCategory);
		String photo = getFieldValue(request, Form.auctionPhoto);
		String startPrice = getFieldValue(request, Form.auctionStartPrice);
		String startDate = getFieldValue(request, Form.auctionStartDate);
		String endDate = getFieldValue(request, Form.auctionEndDate);
		
		
		Auction auction = new Auction();
		
		return auction;
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
