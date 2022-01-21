package com.booking.boot;

import java.text.SimpleDateFormat;

import com.booking.entities.Reservation;
import com.booking.entities.Room;
import com.booking.entities.User;
import com.booking.service.ReservationService;
import com.booking.service.RoomService;
import com.booking.service.UserService;
import com.booking.utils.Constants;

public class Start {

	public static void main(String[] args) throws Exception {

		// STEP 1 - User Service
		UserService userService = new UserService();
		userService.dropTable();
		userService.createTable();
		userService.emptyTable();

		// create main administrator user
		User adminu = new User("admin@mybooking.com", "ADMIN", "ADMIN", "admin@123", true, Constants.ROLE_ADMIN);
		User achraf = new User("aelhaimouti@mybooking.com", "ACHRAF", "EL HAIMOUTI", "achraf@123", true,
				Constants.ROLE_CUSTOMER);
		User jamal = new User("ayajmansourikoubi@mybooking.com", "JAMAL", "EL MANSOURI", "jamal@123", false,
				Constants.ROLE_CUSTOMER);
		userService.create(adminu);
		userService.create(achraf);
		userService.create(jamal);
		System.out.println(userService.findAll());

		// STEP 2 - Room Service
		RoomService roomService = new RoomService();
		roomService.dropTable();
		roomService.createTable();
		roomService.emptyTable();

		// create main rooms
		// type of rooms : Single, Double, Triple, Quad, Queen, King, Twin,
		// Double-double, Studio,
		// Master Suite, MINI-Suite
		roomService.create(new Room(100, "Single", 250, "http://localhost:8080/booking/front/img/rooms/p0.jpg"));
		roomService.create(new Room(101, "Double", 355.50, "http://localhost:8080/booking/front/img/rooms/p1.jpg"));
		roomService.create(new Room(102, "Triple", 750.90, "http://localhost:8080/booking/front/img/rooms/p2.jpg"));
		roomService.create(new Room(103, "Quad", 1000.50, "http://localhost:8080/booking/front/img/rooms/p3.jpg"));
		System.out.println(roomService.findAll());

		// STEP 3 - Reservation Service
		ReservationService reservationService = new ReservationService();
		reservationService.dropTable();
		reservationService.createTable();
		reservationService.emptyTable();

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		reservationService.create(new Reservation(userService.findById(2), roomService.findById(1),
				format.parse("01/01/2022"), format.parse("03/01/2022"), 125.0));
		System.out.println(reservationService.findAll());
	}
}
