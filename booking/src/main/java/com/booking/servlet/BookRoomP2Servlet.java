package com.booking.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booking.service.RoomService;
import com.booking.utils.Constants;

public class BookRoomP2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public BookRoomP2Servlet() {
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
			String destination = "/WEB-INF/jsp/BookRoomP1.jsp";
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
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute(Constants.HTTP_ATT_LOGIN) != null)
		{
			String beginDate = request.getParameter("begin-date");
			String endDate = request.getParameter("end-date");
			
			request.setAttribute("beginDate", beginDate);
			request.setAttribute("endDate", endDate);
			
			RoomService roomService = new RoomService();
			request.setAttribute(Constants.HTTP_ATT_ROOMS, roomService.findAll());
			
			String destination = "/WEB-INF/jsp/BookRoomP2.jsp";
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
}
