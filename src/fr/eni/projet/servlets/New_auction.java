package fr.eni.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.BusinessException;
import fr.eni.projet.bll.AuctionForm;
import fr.eni.projet.bo.SoldItems;

/**
 * Servlet implementation class New_auction
 */
@WebServlet("/New_auction")
public class New_auction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VIEW = "/WEB-INF/jsp/new_auction.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuctionForm form = new AuctionForm();
		
		SoldItems solditem = null;
		
		try {
			soldItem = form.
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		
	}

}
