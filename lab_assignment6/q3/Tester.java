package lab_assignment6.q3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Tester {
	
	public static void main(String[] args) {
		
		Book book1 = new Book(1, "Java Seventh Edition", "Herbert Schildt");
		Book book2 = new Book(2,"C Programming", "Dennis Ritchie");
		Book book3 = new Book(3, "Data Structures", "Narasimha Karumanchi");
		
		
		BookCollection bc = new BookCollection();
		bc.books.add(book1);
		bc.books.add(book2);
		bc.books.add(book3);
		
		System.out.println("Before sorting");
		printBooks(bc.books);
		
		//check whether book is there or not
		Book bookUpdate = new Book("Operating System", "Abraham");
		bc.hasBook(bookUpdate);
		
		//sort
		System.out.println("Sorting by book title");
		bc.sortByBookTitle();
		

		System.out.println("Sorting by author");
		bc.sortByAuthor();
	}
	
	private static void printBooks(List<Book> books) {
		//print the book
		for(Book book: books) {
			System.out.println(book);
		}
	}


}
