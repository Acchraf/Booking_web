package com.booking.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.booking.cnx.DbCnx;
import com.booking.dao.IReservationDao;
import com.booking.entities.Reservation;

public class ReservationService implements IReservationDao {

	public ReservationService() {
		super();
	}

	public void createTable() throws Exception {
		Connection cnx = DbCnx.getConnection();
		Statement statement = cnx.createStatement();

		String sql = "CREATE TABLE if not exists reservation (" + "id integer NOT NULL AUTO_INCREMENT,"
				+ "userId integer NOT NULL," + "roomId integer not NULL," + "beginDate Date not NULL,"
				+ "endDate Date not NULL, " + "price double not NULL," + "FOREIGN KEY (userId) REFERENCES user(id),"
				+ "FOREIGN KEY (roomId) REFERENCES room(id)," + "PRIMARY KEY (id))";

		statement.executeUpdate(sql);
		System.out.println("table reservation created...");
	}

	public void emptyTable() throws Exception {
		Connection cnx = DbCnx.getConnection();
		Statement statement = cnx.createStatement();
		String sql = "TRUNCATE TABLE reservation";
		statement.executeUpdate(sql);
		System.out.println("table reservation empty...");
	}
	
	public void dropTable() throws Exception {
		Connection cnx = DbCnx.getConnection();
		Statement statement = cnx.createStatement();
		String sql = "DROP TABLE IF EXISTS reservation";
		statement.executeUpdate(sql);
		System.out.println("table reservation deleted...");
	}

	@Override
	public boolean create(Reservation reservation) {

		try {
			Connection cnx = DbCnx.getConnection();
			String insertQuery = "INSERT INTO reservation (userId, roomId, beginDate, endDate, price) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pr = cnx.prepareStatement(insertQuery);
			pr.setInt(1, reservation.getCustomer().getId());
			pr.setInt(2, reservation.getRoom().getId());
			pr.setDate(3, new Date(reservation.getBeginDate().getTime()));
			pr.setDate(4, new Date(reservation.getEndDate().getTime()));
			pr.setDouble(5, reservation.getPrice());
			return pr.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Reservation reservation) {

		try {
			Connection cnx = DbCnx.getConnection();
			String query = "UPDATE reservation SET beginDate=?, endDate=?, price=? WHERE id=?";
			PreparedStatement pr = cnx.prepareStatement(query);
			pr.setDate(1, new Date(reservation.getBeginDate().getTime()));
			pr.setDate(2, new Date(reservation.getEndDate().getTime()));
			pr.setDouble(3, reservation.getPrice());
			pr.setInt(4, reservation.getId());
			return pr.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(Reservation reservation) {

		try {
			Connection cnx = DbCnx.getConnection();
			String query = "DELETE FROM reservation WHERE id=?";
			PreparedStatement pr = cnx.prepareStatement(query);
			pr.setInt(1, reservation.getId());
			return pr.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Reservation findById(int id) {

		try {
			Connection cnx = DbCnx.getConnection();
			PreparedStatement pr = cnx.prepareStatement("select * from reservation where id=?");
			pr.setInt(1, id);
			ResultSet resultSet = pr.executeQuery();
			if (resultSet.next()) {
				UserService us = new UserService();
				RoomService rs = new RoomService();
				return new Reservation(resultSet.getInt(1), us.findById(resultSet.getInt(2)),
						rs.findById(resultSet.getInt(3)), resultSet.getDate(4), resultSet.getDate(5),
						resultSet.getDouble(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	

	@Override
	public List<Reservation> findAll() {

		List<Reservation> reservations = new ArrayList<Reservation>();

		try {
			Connection cnx = DbCnx.getConnection();
			Statement statement;
			statement = cnx.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from reservation order by beginDate desc");
			while (resultSet.next()) {
				UserService us = new UserService();
				RoomService rs = new RoomService();
				reservations.add(new Reservation(resultSet.getInt(1), us.findById(resultSet.getInt(2)),
						rs.findById(resultSet.getInt(3)), resultSet.getDate(4), resultSet.getDate(5),
						resultSet.getDouble(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reservations;
	}
	
	@Override
	public List<Reservation> findAllById(int id) {

		List<Reservation> reservations = new ArrayList<Reservation>();

		try {
			Connection cnx = DbCnx.getConnection();
			Statement statement;
			statement = cnx.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from reservation where userId=" + id + " order by beginDate desc");
			while (resultSet.next()) {
				UserService us = new UserService();
				RoomService rs = new RoomService();
				reservations.add(new Reservation(resultSet.getInt(1), us.findById(resultSet.getInt(2)),
						rs.findById(resultSet.getInt(3)), resultSet.getDate(4), resultSet.getDate(5),
						resultSet.getDouble(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reservations;
	}

}
