package com.booking.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.booking.entities.Reservation;
import com.booking.entities.Room;
import com.booking.entities.User;
import com.booking.service.ReservationService;
import com.booking.service.RoomService;
import com.booking.service.UserService;
import com.booking.utils.Constants;

public class Testing {

	public static void main(String[] args) throws Exception {

		UserService userService = new UserService();
		userService.dropTable();
		userService.createTable();
		userService.emptyTable();
		System.out.println(userService.findAll());

		// creation
		User u1 = new User("thenry@mybooking.com", "Tony", "henry", "thenry@123", false, Constants.ROLE_CUSTOMER);
		User u2 = new User("dmaradonna@mybooking.com", "Diego", "Maradonna", "dmaradonna@123", false, Constants.ROLE_ADMIN);
		userService.create(u1);
		userService.create(u2);
		System.out.println(userService.findAll());

		// update
		User u3 = new User(2, "dmaradonna@mybooking.com", "Diego-Armando", "Maradonna", "dmaradonna@123", true,
				Constants.ROLE_CUSTOMER);
		userService.update(u3);
		System.out.println(userService.findAll());

		// delete
		userService.delete(new User(2, "", "", "", "", false, ""));
		System.out.println(userService.findAll());

		// find
		System.out.println(userService.findById(2));
		System.out.println(userService.authenticate("thenry", "thenry@123") != null);

		RoomService roomService = new RoomService();
		roomService.dropTable();
		roomService.createTable();
		roomService.emptyTable();

		Room r1 = new Room(134, "Simple Room", 66.3, "http://localhost:8080/booking/img/rooms/p1.png");
		Room r2 = new Room(135, "Simple Room", 79.0, "http://localhost:8080/booking/img/rooms/p2.png");
		roomService.create(r1);
		roomService.create(r2);
		System.out.println(roomService.findAll());

		roomService.update(new Room(2, 136, "Sweet", 81.1, "http://localhost:8080/booking/front/img/rooms/p0.jpg"));
		System.out.println(roomService.findAll());

		ReservationService reservationService = new ReservationService();
		reservationService.dropTable();
		reservationService.createTable();
		reservationService.emptyTable();

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date begin = format.parse("01/01/2022");
		Date end = format.parse("03/01/2022");
		reservationService.create(new Reservation(userService.findById(1), roomService.findById(1), begin, end, 50.0));
		System.out.println(reservationService.findAll());
	}
}
