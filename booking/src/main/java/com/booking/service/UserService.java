package com.booking.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.booking.cnx.DbCnx;
import com.booking.dao.IUserDao;
import com.booking.entities.User;

public class UserService implements IUserDao {

	public UserService() {
		super();
	}

	public void createTable() throws Exception {
		Connection cnx = DbCnx.getConnection();
		Statement statement = cnx.createStatement();

		String sql = "CREATE TABLE if not exists user (" + "id integer NOT NULL AUTO_INCREMENT,"
				+ "email VARCHAR(100) NOT NULL," + "firstname VARCHAR(100) NOT NULL,"
				+ "lastname VARCHAR(100) NOT NULL," + "password VARCHAR(100) NOT NULL," + "state boolean NOT NULL, "
				+ "role VARCHAR(100) NOT NULL," + "PRIMARY KEY (id))";

		statement.executeUpdate(sql);
		System.out.println("table user created...");
	}

	public void emptyTable() throws Exception {
		Connection cnx = DbCnx.getConnection();
		Statement statement = cnx.createStatement();
		String sql = "TRUNCATE TABLE user";
		statement.executeUpdate(sql);
		System.out.println("table user empty...");
	}
	
	public void dropTable() throws Exception {
		Connection cnx = DbCnx.getConnection();
		Statement statement = cnx.createStatement();
		String sql = "DROP TABLE IF EXISTS user";
		statement.executeUpdate(sql);
		System.out.println("table user deleted...");
	}

	@Override
	public boolean create(User user) {

		try {
			Connection cnx = DbCnx.getConnection();
			String insertQuery = "INSERT INTO user (email, firstname, lastname, password, state, role) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pr = cnx.prepareStatement(insertQuery);
			pr.setString(1, user.getEmail());
			pr.setString(2, user.getFirstname());
			pr.setString(3, user.getLastname());
			pr.setString(4, user.getPassword());
			pr.setBoolean(5, user.getState());
			pr.setString(6, user.getRole());
			return pr.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(User user) {

		try {
			Connection cnx = DbCnx.getConnection();
			String query = "UPDATE user " + "SET email=?," + "firstname=?, " + "lastname=?, " + "password=?, "
					+ "state=?, " + "role=? " + "WHERE id=?";
			PreparedStatement pr = cnx.prepareStatement(query);
			pr.setString(1, user.getEmail());
			pr.setString(2, user.getFirstname());
			pr.setString(3, user.getLastname());
			pr.setString(4, user.getPassword());
			pr.setBoolean(5, user.getState());
			pr.setString(6, user.getRole());
			pr.setInt(7, user.getId());
			return pr.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(User user) {

		try {
			Connection cnx = DbCnx.getConnection();
			String query = "DELETE FROM user WHERE id=?";
			PreparedStatement pr = cnx.prepareStatement(query);
			pr.setInt(1, user.getId());
			return pr.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public User findById(int id) {

		try {
			Connection cnx = DbCnx.getConnection();
			PreparedStatement pr = cnx.prepareStatement("select * from user where id=?");
			pr.setInt(1, id);
			ResultSet resultSet = pr.executeQuery();
			if (resultSet.next()) {
				return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getBoolean(6),
						resultSet.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User findByEmail(String email) {

		try {
			Connection cnx = DbCnx.getConnection();
			PreparedStatement pr = cnx.prepareStatement("select * from user where email=?");
			pr.setString(1, email);
			ResultSet resultSet = pr.executeQuery();
			if (resultSet.next()) {
				return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getBoolean(6),
						resultSet.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<User> findAll() {

		List<User> users = new ArrayList<User>();

		try {
			Connection cnx = DbCnx.getConnection();
			Statement statement;
			statement = cnx.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user");
			while (resultSet.next()) {
				users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getBoolean(6),
						resultSet.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public List<User> findAllCustomers() {

		List<User> users = new ArrayList<User>();

		try {
			Connection cnx = DbCnx.getConnection();
			Statement statement;
			statement = cnx.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user where role='customer'");
			while (resultSet.next()) {
				users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getBoolean(6),
						resultSet.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public List<User> findAllAdministrators() {

		List<User> users = new ArrayList<User>();

		try {
			Connection cnx = DbCnx.getConnection();
			Statement statement;
			statement = cnx.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user role='admin'");
			while (resultSet.next()) {
				users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getBoolean(6),
						resultSet.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User authenticate(String id, String password) {

		User user = null;

		try {

			Connection cnx = DbCnx.getConnection();
			String query = "select * from user where email=? and password=?";
			PreparedStatement statement = cnx.prepareStatement(query);
			statement.setString(1, id);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getBoolean(6),
						resultSet.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

}
