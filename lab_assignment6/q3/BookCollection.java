package lab_assignment6.q3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookCollection {
	private String authorName;
	List<Book> books = new ArrayList<Book>();

	public void hasBook(Book book) {
		boolean findBook = false;
		if (books.contains(book)) {
			findBook = true;
		}
		if (findBook) {
			System.out.println("Book is found");
		} else {
			System.out.println("Book is not found");
		}
	}

	public void sortByBookTitle() {
		Collections.sort(books, new sortByBookTitle());
		printBooks();
	}

	public void sortByAuthor() {
		Collections.sort(books, new sortByAuthorName());
		printBooks();
	}

	public void printBooks() {
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookCollection [");
		for (int i = 0; i < books.size(); i++) {
			builder.append(" [author =");
			builder.append(books.get(i).getAuthorName());
			builder.append(" title =");
			builder.append(books.get(i).getBookTitle());
			builder.append("]");
		}
		builder.append(" ]");
		return builder.toString();
	}

}
