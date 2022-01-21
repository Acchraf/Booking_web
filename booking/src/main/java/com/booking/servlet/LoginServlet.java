package com.booking.servlet;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booking.entities.User;
import com.booking.service.UserService;
import com.booking.utils.Constants;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute(Constants.HTTP_ATT_DSPLG, "none");
		request.setAttribute(Constants.HTTP_ATT_LOGIN, "");

		String destination = "/WEB-INF/jsp/Login.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter(Constants.HTTP_PARAM_LOGIN);
		String pwd = request.getParameter(Constants.HTTP_PARAM_PASSWORD);

		request.setAttribute(Constants.HTTP_ATT_DSPLG, "none");

		if (Objects.nonNull(login) && Objects.nonNull(pwd)) {

			UserService us = new UserService();

			User user = us.authenticate(login, pwd);

			if (user != null) {
				if (user.getState()) {
					HttpSession session = request.getSession();
					System.out.println("New Session -> " + session.getId());
					if (Constants.ROLE_ADMIN.equals(user.getRole())) {
						session.setAttribute(Constants.HTTP_ATT_LOGIN, login);
						response.sendRedirect("/booking/customers");
					} else {
						session.setAttribute(Constants.HTTP_ATT_LOGIN, login);
						response.sendRedirect("/booking/customer-reservations?id=" + user.getId());
					}
				} else {
					request.setAttribute(Constants.HTTP_ATT_LOGIN, login);
					request.setAttribute(Constants.HTTP_ATT_DSPIU, "block");
					String destination = "/WEB-INF/jsp/Login.jsp";
					RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
					requestDispatcher.forward(request, response);
				}
			} else {
				request.setAttribute(Constants.HTTP_ATT_LOGIN, login);
				request.setAttribute(Constants.HTTP_ATT_DSPLG, "block");
				String destination = "/WEB-INF/jsp/Login.jsp";
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
				requestDispatcher.forward(request, response);
			}
		} else {
			String destination = "/WEB-INF/jsp/Login.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
			requestDispatcher.forward(request, response);
		}
	}
}
