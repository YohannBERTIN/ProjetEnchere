package fr.eni.projet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class index_login
 */
@WebServlet("/Index_login")
public class index_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String VIEW = "/WEB-INF/jsp/index_login.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		goToIndexLogin(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		goToIndexLogin(request, response);
	}
	
	/**
	 * Redirect to profil page
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void goToIndexLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}
}
