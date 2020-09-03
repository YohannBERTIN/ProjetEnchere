package fr.eni.projet.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.AuctionForm;
import fr.eni.projet.bo.User;

/**
 * Servlet implementation class Auction
 */
@WebServlet("/Auction")
public class Auction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index_login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuctionForm form = new AuctionForm();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		Date auctionDate = new Date();
		
		// [ ] Enchérir:
		
		// [ ] récupérer la date, l'heure, le montant de l'enchere:
		request.setAttribute("auctionDate", auctionDate);
		request.setAttribute("auctionerUser", user);
		// [ ] Enregistrer la date, l'heure, le montant de l'enchere en base de données:
	}

}
