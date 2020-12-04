package com.bookapp.web;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.dao.Book;
import com.bookapp.service.BookService;

public class Main {
	
	public static void main(String[] args) {
	
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		BookService bookService = (BookService) ctx.getBean("bookService");
		
//		List<Book> books = bookService.getAllBooks();
//		books.forEach(b -> System.out.println(b));
		
		//find book by id
		
//		Book book = bookService.getBookById(1);
//		System.out.println(book);
		
//		Book book = new Book("A123", "Spring in action", "baytes", 1000);
//		bookService.updateBook(1, book);
		
//		System.out.println("---------after updation---------------");
//		List<Book> books = bookService.getAllBooks();
//		books.forEach(b -> System.out.println(b));
		
//		Book b = new Book("RE123", "LIFE IS COOL", "divya", 560);
//		bookService.addBook(b);
		System.out.println("-----------------------after add books-----------------------");
		List<Book> books = bookService.getAllBooks();
		books.forEach(book -> System.out.println(book));
		
	}
}
