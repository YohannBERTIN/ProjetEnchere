package fr.eni.projet.bll;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.projet.BusinessException;
import fr.eni.projet.Form;
import fr.eni.projet.bo.Item;
import fr.eni.projet.bo.Pickup;
import fr.eni.projet.bo.User;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.ItemDAO;

public class ItemForm {

	public static final String ITEM_FIELD = "itemName";
	public static final String DESCRIPTION_FIELD = "itemDescription";
	public static final String CATEGORY_FIELD = "itemCategory";
	public static final String PHOTO_FIELD = "itemPhoto";
	public static final String START_PRICE_FIELD = "itemStartPrice";
	public static final String START_DATE_FIELD = "itemStartDate";
	public static final String END_DATE_FIELD = "itemEndDate";
	
	public static final String STREET_FIELD = "userStreet";
	public static final String ZIP_FIELD = "userZip";
	public static final String CITY_FIELD = "userCity";
	
	//public static final String BDD_ID = "no_utilisateur";
	//public static final String BDD_ITEM_ID = "no_article";
	
	private ItemDAO itemDAO;
	
	private String result;
	private Map<String, String> errors = new HashMap<String, String>();
	
	public String getResult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public void addItem(HttpServletRequest request) throws BusinessException {
		
		this.itemDAO = DAOFactory.getItemDAO();
				
		Item item = addItemIdentity(request);
		Pickup pickup = addPickup(request);
		
		//test
		System.out.println("ItemForm : Item généré = "+ item);
		System.out.println("ItemForm : Pickup généré = "+ pickup);
		
		this.itemDAO.insert(item, pickup);	
	}
	
	public Item addItemIdentity(HttpServletRequest request) throws BusinessException {
		
		Item item = new Item();
		User user = (User) request.getAttribute("sellerUser");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm");
		
		item.setNomArticle(getFieldValue(request, Form.itemTitle));
		item.setDescription(getFieldValue(request, Form.itemDescription));
		//item.setNoCategorie(Integer.parseInt(getFieldValue(request, Form.itemCategory)));
		item.setNoCategorie(1);
		item.setPrixInitial(Integer.parseInt(getFieldValue(request, Form.itemStartPrice)));
		item.setDateDebutEnchere(LocalDate.parse(getFieldValue(request, Form.itemStartDate), dtf));
		item.setDateFinEnchere(LocalDate.parse(getFieldValue(request, Form.itemEndDate), dtf));
		item.setTimeStart(LocalTime.parse(getFieldValue(request, Form.itemStartTime), dtf1));
		item.setTimeEnd(LocalTime.parse(getFieldValue(request, Form.itemEndTime), dtf1));
		item.setNoUtilisateur(user.getUserId());
		
		return item;	
	}
	
	public Pickup addPickup(HttpServletRequest request) throws BusinessException {
		
		this.itemDAO = DAOFactory.getItemDAO();
		Pickup pickup = new Pickup();
		
		pickup.setRue(getFieldValue(request, Form.pickupStreet));
		pickup.setCodePostal(getFieldValue(request, Form.pickupZip));
		pickup.setVille(getFieldValue(request, Form.pickupCity));
		
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
