package fr.eni.projet.bll;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.projet.BusinessException;
import fr.eni.projet.Form;
import fr.eni.projet.bo.Auctions;
import fr.eni.projet.bo.Pickup;
import fr.eni.projet.bo.SoldItems;
import fr.eni.projet.dal.AuctionDAO;
import fr.eni.projet.dal.DAOFactory;

public class AuctionForm {

	public static final String ITEM_FIELD = "auctionName";
	public static final String DESCRIPTION_FIELD = "auctionDescription";
	public static final String CATEGORY_FIELD = "auctionCategory";
	public static final String PHOTO_FIELD = "auctionPhoto";
	public static final String START_PRICE_FIELD = "auctionStartPrice";
	public static final String START_DATE_FIELD = "auctionStartDate";
	public static final String END_DATE_FIELD = "auctionEndDate";
	
	public static final String STREET_FIELD = "userStreet";
	public static final String ZIP_FIELD = "userZip";
	public static final String CITY_FIELD = "userCity";
	
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
	
	public Auctions addAuction(HttpServletRequest request) throws BusinessException {
		
		this.auctionDAO = DAOFactory.getAuctionDAO();
		
		
		int startPrice = Integer.parseInt(getFieldValue(request, Form.auctionStartPrice));
		String startDate = getFieldValue(request, Form.auctionStartDate);
		LocalDateTime endDate = getFieldValue(request, Form.auctionEndDate);
		
		Auctions auction = new Auctions();
		
		auction.setMontantEnchere(startPrice);
		auction.setDateEnchere(startDate);
		
		
		return auction;
	}
	
	public SoldItems addSoldItem(HttpServletRequest request) throws BusinessException {
		
		this.auctionDAO = DAOFactory.getAuctionDAO();
		
		String title = getFieldValue(request, Form.auctionTitle);
		String description = getFieldValue(request, Form.auctionDescription);
		String category = getFieldValue(request, Form.auctionCategory);
		String photo = getFieldValue(request, Form.auctionPhoto);
				
		SoldItems soldItem = new SoldItems();
		
		soldItem.setNomArticle(title);
		soldItem.setDescription(description);
		soldItem.setNoCategorie(category);
		
		return soldItem;
	}
	
	public Pickup addPickup(HttpServletRequest request) throws BusinessException {
		
		this.auctionDAO = DAOFactory.getAuctionDAO();
		
		String street = getFieldValue(request, Form.userStreet);
		String zip = getFieldValue(request, Form.userZipCode);
		String city = getFieldValue(request, Form.userCity);
		
		Pickup pickup = new Pickup();
		
		return pickup;
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
