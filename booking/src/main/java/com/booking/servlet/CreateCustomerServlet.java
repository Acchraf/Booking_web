package com.booking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.entities.User;
import com.booking.service.UserService;

public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CreateCustomerServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String destination = "/WEB-INF/jsp/CreateCustomer.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String firstname = request.getParameter("first-name");
		String lastname = request.getParameter("last-name");
		String password = request.getParameter("password");
		String role = "customer";

		UserService us = new UserService();

		if (us.findByEmail(email) != null) {
			String destination = "/WEB-INF/jsp/CreateCustomer.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
			requestDispatcher.forward(request, response);
		} else {
			us.create(new User(email, firstname, lastname, password, false, role));
			response.sendRedirect("/booking/login");
		}
	}
}
