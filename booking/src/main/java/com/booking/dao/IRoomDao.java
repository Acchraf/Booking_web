package com.booking.dao;

import java.util.List;

import com.booking.entities.Room;

public interface IRoomDao {

	public boolean create(Room o);

	public boolean update(Room o);

	public boolean delete(Room o);

	public Room findById(int id);

	public List<Room> findAll();
}
