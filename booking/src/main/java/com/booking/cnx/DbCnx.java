package com.booking.cnx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCnx {
	
	public static final String DB_URL = "jdbc:mysql://localhost/booking_web?useSSL=false";
	public static final String USER = "root";
	public static final String PASS = "";

	private static Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Impossible de charger le driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Imoossible d'étabir la connexion");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
	
}
