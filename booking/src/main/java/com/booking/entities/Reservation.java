package com.booking.entities;

import java.util.Date;

public class Reservation {

	private int id;
	private User customer;
	private Room room;
	private Date beginDate;
	private Date endDate;
	private Double price;

	public Reservation() {
		super();
	}

	public Reservation(User customer, Room room, Date beginDate, Date endDate, Double price) {
		super();
		this.customer = customer;
		this.room = room;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.price = price;
	}
	
	public Reservation(int id, User customer, Room room, Date beginDate, Date endDate, Double price) {
		super();
		this.id = id;
		this.customer = customer;
		this.room = room;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", customer=" + customer + ", room=" + room + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + ", price=" + price + "]";
	}
}
