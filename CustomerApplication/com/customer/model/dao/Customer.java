package com.customer.model.dao;

import java.util.Date;

public class Customer {
	private int id;
	private String name;
	private String phone;
	private String email;
	private Date birthDate;
	private String address;
	private double purchaseCapacity;

	public Customer(int id, String name, String phone, String email, Date birthDate, String address,
			double purchaseCapacity) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
		this.address = address;
		this.purchaseCapacity = purchaseCapacity;
	}
	
	public Customer(String name, String phone, String email, Date birthDate, String address,
			double purchaseCapacity) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
		this.address = address;
		this.purchaseCapacity = purchaseCapacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPurchaseCapacity() {
		return purchaseCapacity;
	}

	public void setPurchaseCapacity(int purchaseCapacity) {
		this.purchaseCapacity = purchaseCapacity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", address=");
		builder.append(address);
		builder.append(", purchaseCapacity=");
		builder.append(purchaseCapacity);
		builder.append("]");
		return builder.toString();
	}

}
