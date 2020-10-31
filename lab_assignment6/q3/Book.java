package lab_assignment6.q3;

import java.util.Comparator;

class sortByBookTitle implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getBookTitle().compareTo(o2.getBookTitle());
	}

}

class sortByAuthorName implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getAuthorName().compareTo(o2.getAuthorName());
	}

}

public class Book implements Comparable<Book> {
	private int id;
	private String bookTitle;
	private String authorName;

	public Book(int id, String bookTitle, String authorName) {
		this.id = id;
		this.bookTitle = bookTitle;
		this.authorName = authorName;
	}

	public Book(String bookName, String author) {
		this.bookTitle = bookName;
		this.authorName = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=");
		builder.append(id);
		builder.append(", bookTitle=");
		builder.append(bookTitle);
		builder.append(", authorName=");
		builder.append(authorName);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Book b1) {
		// TODO Auto-generated method stub
		return Integer.compare(b1.getId(), this.getId());
	}

}
