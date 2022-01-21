package com.booking.entities;

public class Room {

	private int id;
	private int number;
	private String type;
	private double price;
	private String photo;

	public Room(int number, String type, double price, String photo) {
		super();
		this.number = number;
		this.type = type;
		this.price = price;
		this.photo = photo;
	}
	
	public Room(int id, int number, String type, double price, String photo) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.price = price;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", type=" + type + ", price=" + price + ", photo=" + photo
				+ "]";
	}
}
