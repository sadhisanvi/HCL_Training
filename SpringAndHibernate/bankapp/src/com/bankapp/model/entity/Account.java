package com.bankapp.model.entity;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="account_table")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id")
	private Integer accountId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private Double balance;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String phone;
	
	@Column(nullable=false)
	private String email;

	@Column(unique=true,nullable=false)
	private String aadharCard;

	@Column(unique=true,nullable=false)
	private String panNumber;
	
	private AccountStatus accountStatus = AccountStatus.ACTIVE;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	
	@JoinColumn(name="accountId_fk")
	@OneToMany(cascade=CascadeType.ALL,fetch= FetchType.LAZY)
	private List<TransactionLog> transactionLog = new ArrayList<TransactionLog>();
	
	
	
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
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

	public List<TransactionLog> getTransactionLog() {
		return transactionLog;
	}

	public void setTransactionLog(List<TransactionLog> transactionLog) {
		this.transactionLog = transactionLog;
	}

	

	public Account(String name, Double balance, String address, String phone, String email, String aadharCard,
			String panNumber, AccountType accountType) {
	
		this.name = name;
		this.balance = balance;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.aadharCard = aadharCard;
		this.panNumber = panNumber;
		this.accountType = accountType;
	}

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name + ", balance=" + balance + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", aadharCard=" + aadharCard + ", panNumber=" + panNumber
				+ "]";
	}
	
	
	
}
