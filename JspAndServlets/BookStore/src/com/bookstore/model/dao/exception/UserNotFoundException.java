package com.bookstore.model.dao.exception;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -8640609886084977390L;

	public UserNotFoundException(String message) {
		super(message);
	}
}