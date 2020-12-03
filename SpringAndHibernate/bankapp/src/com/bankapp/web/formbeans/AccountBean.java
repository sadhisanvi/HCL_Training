package com.bankapp.web.formbeans;


import org.hibernate.validator.constraints.NotEmpty;

public class AccountBean {

	private Integer accountId;

	@NotEmpty(message = "Username can not be left blank")
	private String name;

	@NotEmpty(message = "Password can not be left blank")
	private Double balance;

	@NotEmpty(message = "Address can not be left blank")
	private String address;

	@NotEmpty(message = "Phone number can not be left blank")
	private String phone;

	@NotEmpty(message = "Email can not be left blank")
	private String email;
	
	@NotEmpty(message = "Aadhar Card can not be left blank")
	private String aadharCard;
	
	@NotEmpty(message = "Pan Number can not be left blank")
	private String panNumber;

	public Integer getAccount_id() {
		return accountId;
	}

	public void setAccount_id(Integer account_id) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	
	
}