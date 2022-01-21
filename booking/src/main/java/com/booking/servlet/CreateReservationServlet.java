package com.booking.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booking.entities.Reservation;
import com.booking.entities.Room;
import com.booking.entities.User;
import com.booking.service.ReservationService;
import com.booking.utils.Constants;

public class CreateReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CreateReservationServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute(Constants.HTTP_ATT_LOGIN) != null) {
			String destination = "/WEB-INF/jsp/BookRoomP1.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
			requestDispatcher.forward(request, response);
		} else {
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

		int customer = 0;
		if (request.getParameter("customer") != null) {
			customer = Integer.valueOf(request.getParameter("customer"));
		}
		int room = 0;
		if (request.getParameter("room") != null) {
			room = Integer.valueOf(request.getParameter("room"));
		}
		double price = 0.0;
		if (request.getParameter("price") != null) {
			price = Double.valueOf(request.getParameter("price"));
		}
		String beginDate = request.getParameter("begin-date");
		String endDate = request.getParameter("end-date");

		ReservationService us = new ReservationService();

		User u = new User(customer, "", "", "", "", true, "");
		Room r = new Room(room, 0, "", 0.0, "");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date begin = format.parse(beginDate);
			Date end = format.parse(endDate);
			us.create(new Reservation(u, r, begin, end, round(price * numberOfDays(begin, end), 2)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("/booking/customer-reservations?id=" + customer);
	}
	
	private double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	private int numberOfDays(Date d1, Date d2) {

		if (d1 != null && d2 != null) {
			if (d1.before(d2)) {
				return (int) ChronoUnit.DAYS.between(convertToLocalDateViaSqlDate(d1),
						convertToLocalDateViaSqlDate(d2));
			} else {
				return (int) ChronoUnit.DAYS.between(convertToLocalDateViaSqlDate(d2),
						convertToLocalDateViaSqlDate(d1));
			}
		}

		return 1;
	}

	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
		return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
}
