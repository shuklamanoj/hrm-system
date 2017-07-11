package com.hrsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrsystem.dao.IRecruiterDao;
import com.hrsystem.dao.factory.DaoFactory;

/**
 * Servlet implementation class RecruiterLogin
 */
@WebServlet(name = "recruiterLogin", urlPatterns = { "/recruiterLogin" })
public class RecruiterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/rec");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("recName") == null) {
			System.out.println("do post called");
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			IRecruiterDao recruiterDAO = DaoFactory.getRecruiterDao();
			if (recruiterDAO.authenticateRecruiter(email, passwd)) {
				session = request.getSession(true);
				//System.out.println(recruiterDAO.getNameByEmail(email));
				session.setAttribute("recName", recruiterDAO.getNameByEmail(email));
				session.setAttribute("recID", recruiterDAO.getIdByEmail(email));
				System.out.println("Rec validated");
				response.sendRedirect(request.getContextPath() + "/rec");
			} else {
				request.setAttribute("errorMessage",
						"Plz enter valid credentials !!");
				request.getRequestDispatcher("/rec/index.jsp").forward(request,
						response);
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/rec");
		}
	}

}
