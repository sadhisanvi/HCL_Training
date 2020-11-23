package com.bookapp.web;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.dao.Book;
import com.bookapp.service.BookService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		BookService bookService = ctx.getBean("bookService",BookService.class);
		
		//BookService bookService = (BookService)ctx.getBean("bookService");
		
		//Adding the book
		bookService.addBook(new Book("A2344","Java","Herbert",500));
		
		//deleting the book
		bookService.deleteBook(3);
		
		//getting all the books
		List<Book> books = bookService.getAllBooks();
		books.forEach(a -> System.out.println(a));
		
		//Updating the book
		bookService.updateBook(2,new Book("A2344","Java","Herbert",500));
		
		//getting book by id
		Book book = bookService.getBookById(2);
		System.out.println(book);	
		
	}

}
