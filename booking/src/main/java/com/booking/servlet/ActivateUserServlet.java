package com.booking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booking.entities.User;
import com.booking.service.UserService;
import com.booking.utils.Constants;

public class ActivateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ActivateUserServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if(session.getAttribute(Constants.HTTP_ATT_LOGIN) != null)
		{
			UserService us = new UserService();
			request.setAttribute(Constants.HTTP_ATT_USERS, us.findAll());

			String destination = "/WEB-INF/jsp/DisplayCustomers.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
			requestDispatcher.forward(request, response);		
		}
		else
		{
			String destination = "/WEB-INF/jsp/Login.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
			requestDispatcher.forward(request, response);				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = 0;
		if(request.getParameter("userID") != null)
		{
			id = Integer.valueOf(request.getParameter("userID"));
		}

		UserService us = new UserService();
		
		User user = us.findById(id);
		user.setState(true);
		
		us.update(user);
		response.sendRedirect("/booking/customers");
	}
}
