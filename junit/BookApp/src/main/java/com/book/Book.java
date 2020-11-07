package com.book;

public class Book {
	
	private int id;
	private String bookName;
	private String iSBN;
	
	
	public Book() {
	}


	public Book(int id, String bookName, String iSBN) {
		this.id = id;
		this.bookName = bookName;
		this.iSBN = iSBN;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getiSBN() {
		return iSBN;
	}


	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=");
		builder.append(id);
		builder.append(", bookName=");
		builder.append(bookName);
		builder.append(", iSBN=");
		builder.append(iSBN);
		builder.append("]");
		return builder.toString();
	}
	
}