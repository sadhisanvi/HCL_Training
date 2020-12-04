package com.bookapp.model.dao.exceptions;

public class AccountNotFoundException extends RuntimeException{
	
	public AccountNotFoundException(String message) {
		super(message);
	}
	
}
