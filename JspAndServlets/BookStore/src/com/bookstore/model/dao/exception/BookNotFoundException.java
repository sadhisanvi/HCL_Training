package com.bookstore.model.dao.exception;

public class BookNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -8640609886084977390L;

	public BookNotFoundException(String message) {
		super(message);
	}
}