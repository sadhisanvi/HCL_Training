package com.book;

import java.util.List;

interface BookDao {
	
	public List<Book> getAllBooks();
	public void addBook(Book book);
	public Book updateBook(String iSBN, String bookName);
	public void delBook(String iSBN);
	

}