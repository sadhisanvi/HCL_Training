package com.bookapp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.Book;
import com.bookapp.dao.BookDao;

@Service(value="bookService")
public  class BookServiceImpl implements BookService {

	//BAD CODE HARD CODING....

	private BookDao dao;
	
	List<Book> list;
	
	
	public BookServiceImpl() {
		
	}
	
	@Autowired
	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	
	public BookServiceImpl(List<Book> list) {
		this.list = list;
	}
	

	@Override
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	@Override
	public void addBook(Book book) {
		 dao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		dao.deleteBook(id);
	}

	@Override
	public void updateBook(int id, Book book) {
		dao.updateBook(id, book);
	}

	@Override
	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

}