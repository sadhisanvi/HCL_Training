package com.book;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

	List<Book> listBooks;

	public BookDaoImpl() {
		listBooks = new ArrayList<Book>();
		listBooks.add(new Book(1, "Java", "123456"));
		listBooks.add(new Book(2, "Data Structures", "123"));
		listBooks.add(new Book(3, "python", "456"));
		listBooks.add(new Book(4, "spring", "789"));
	}

	public List<Book> getAllBooks() {
		System.out.println(listBooks.get(0));
		return listBooks;
	}

	public void addBook(Book book) {
		listBooks.add(book);
	}

	public Book updateBook(String bookName, String iSBN) {

		int index = 0;
		for (int i = 0; i < listBooks.size(); i++) {
			if (listBooks.get(i).getiSBN().equals(iSBN)) {
				index = i;
				listBooks.get(i).setBookName(bookName);
			}
		}
		return listBooks.get(index);
	}
	

	public void delBook(String iSBN) {

		boolean isIndex = false;
		for (int i = 0; i < listBooks.size(); i++) {
			if (listBooks.get(i).getiSBN().equals(iSBN)) {
				isIndex = true;
				listBooks.remove(i);
			}
		}
		if(!isIndex) {
			throw new BookNotFoundException("not found!");
		}
//		System.out.println(listBooks);
		
	}
}
