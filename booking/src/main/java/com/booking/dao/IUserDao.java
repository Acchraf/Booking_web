package com.booking.dao;

import java.util.List;

import com.booking.entities.User;

public interface IUserDao {

	public boolean create(User o);

	public boolean update(User o);

	public boolean delete(User o);

	public User findById(int id);
	
	public User findByEmail(String email);

	public List<User> findAll();

	public List<User> findAllCustomers();

	public List<User> findAllAdministrators();
}
