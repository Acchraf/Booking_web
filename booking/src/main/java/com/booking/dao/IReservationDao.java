package com.booking.dao;

import java.util.List;

import com.booking.entities.Reservation;

public interface IReservationDao {

	public boolean create(Reservation o);

	public boolean update(Reservation o);

	public boolean delete(Reservation o);

	public Reservation findById(int id);

	public List<Reservation> findAll();
	public List<Reservation> findAllById(int id);
}
