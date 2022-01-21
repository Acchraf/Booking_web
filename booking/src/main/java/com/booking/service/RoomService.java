package com.booking.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.booking.cnx.DbCnx;
import com.booking.dao.IRoomDao;
import com.booking.entities.Room;

public class RoomService implements IRoomDao {

	public RoomService() {
		super();
	}

	public void createTable() throws Exception {
		Connection cnx = DbCnx.getConnection();
		Statement statement = cnx.createStatement();

		String sql = "CREATE TABLE if not exists room (" + "id integer NOT NULL AUTO_INCREMENT,"
				+ "number integer NOT NULL," + "type VARCHAR(100) NOT NULL," + "price double NOT NULL,"
				+ "photo VARCHAR(4000) NOT NULL," + "PRIMARY KEY (id))";

		statement.executeUpdate(sql);
		System.out.println("table room created...");
	}

	public void emptyTable() throws Exception {
		Connection cnx = DbCnx.getConnection();
		Statement statement = cnx.createStatement();
		String sql = "TRUNCATE TABLE room";
		statement.executeUpdate(sql);
		System.out.println("table room empty...");
	}

	public void dropTable() throws Exception {
		Connection cnx = DbCnx.getConnection();
		Statement statement = cnx.createStatement();
		String sql = "DROP TABLE IF EXISTS room";
		statement.executeUpdate(sql);
		System.out.println("table room deleted...");
	}

	@Override
	public boolean create(Room room) {

		try {
			Connection cnx = DbCnx.getConnection();
			String insertQuery = "INSERT INTO room (number, type, price, photo) VALUES (?, ?, ?, ?)";
			PreparedStatement pr = cnx.prepareStatement(insertQuery);
			pr.setInt(1, room.getNumber());
			pr.setString(2, room.getType());
			pr.setDouble(3, room.getPrice());
			pr.setString(4, room.getPhoto());
			return pr.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Room room) {

		try {
			Connection cnx = DbCnx.getConnection();
			String query = "UPDATE room " + "SET number=?, " + "type=?, " + "price=?, " + "photo=? " + "WHERE id=?";
			PreparedStatement pr = cnx.prepareStatement(query);
			pr.setInt(1, room.getNumber());
			pr.setString(2, room.getType());
			pr.setDouble(3, room.getPrice());
			pr.setString(4, room.getPhoto());
			pr.setInt(5, room.getId());
			return pr.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(Room room) {

		try {
			Connection cnx = DbCnx.getConnection();
			String query = "DELETE FROM room WHERE id=?";
			PreparedStatement pr = cnx.prepareStatement(query);
			pr.setInt(1, room.getId());
			return pr.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Room findById(int id) {

		try {
			Connection cnx = DbCnx.getConnection();
			PreparedStatement pr = cnx.prepareStatement("select * from room where id=?");
			pr.setInt(1, id);
			ResultSet resultSet = pr.executeQuery();
			if (resultSet.next()) {
				return new Room(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getDouble(4), resultSet.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Room> findAll() {

		List<Room> rooms = new ArrayList<Room>();

		try {
			Connection cnx = DbCnx.getConnection();
			Statement statement;
			statement = cnx.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from room");
			while (resultSet.next()) {
				rooms.add(new Room(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getDouble(4), resultSet.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rooms;
	}
}
