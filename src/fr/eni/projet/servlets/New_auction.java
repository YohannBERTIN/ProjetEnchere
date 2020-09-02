package fr.eni.projet.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.BusinessException;
import fr.eni.projet.Form;
import fr.eni.projet.View;
import fr.eni.projet.bll.ItemForm;
import fr.eni.projet.bo.Item;
import fr.eni.projet.bo.Pickup;
import fr.eni.projet.bo.User;

/**
 * Servlet implementation class New_auction
 */
@WebServlet("/New_auction")
public class New_auction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_SESSION_USER = "sessionUser";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(View.newAuction).forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		ItemForm form = new ItemForm();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(ATT_SESSION_USER);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm");
		
		Item itemTest = new Item();
		Pickup pickupTest = new Pickup();
		
		pickupTest.setRue(getFieldValue(request, Form.pickupStreet));
		pickupTest.setCodePostal(getFieldValue(request, Form.pickupZip));
		pickupTest.setVille(getFieldValue(request, Form.pickupCity));
		
		itemTest.setNomArticle(getFieldValue(request, Form.itemTitle));
		itemTest.setDescription(getFieldValue(request, Form.itemDescription));
		//item.setNoCategorie(Integer.parseInt(getFieldValue(request, Form.itemCategory)));
		itemTest.setNoCategorie(1);
		itemTest.setPrixInitial(Integer.parseInt(getFieldValue(request, Form.itemStartPrice)));
		itemTest.setDateDebutEnchere(LocalDate.parse(getFieldValue(request, Form.itemStartDate), dtf));
		itemTest.setDateFinEnchere(LocalDate.parse(getFieldValue(request, Form.itemEndDate), dtf));
		itemTest.setTimeStart(LocalTime.parse(getFieldValue(request, Form.itemStartTime), dtf1));
		itemTest.setTimeEnd(LocalTime.parse(getFieldValue(request, Form.itemEndTime), dtf1));
		itemTest.setNoUtilisateur((long) 2);
		itemTest.setPickup(pickupTest);
		
		//test
		System.out.println("Servlet : user de la session : " + user);
		System.out.println("Servlet : item de la session : " + itemTest);
		
		
		request.setAttribute("sellerUser", user);
		
		try {
			form.addItem(request);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher(View.newAuction).forward(request, response);	
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
