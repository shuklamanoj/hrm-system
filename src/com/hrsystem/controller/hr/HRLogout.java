package com.hrsystem.controller.hr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HRLogout
 */
@WebServlet(name = "hrLogout", urlPatterns = { "/hrLogout" })
public class HRLogout extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4700278494960013235L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null){
			response.sendRedirect(request.getContextPath()+"/");
		}
		else{
			session.removeAttribute("hrName");
			session.removeAttribute("hrID");
			session.invalidate();
			request.setAttribute("errorMessage", "HR Logged Out !!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}