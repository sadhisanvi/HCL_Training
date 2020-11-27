package com.bookstore.model.dao.book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bookstore.connection.ConnectionFactory;
import com.bookstore.model.dao.exception.BookNotFoundException;
import com.bookstore.model.dao.exception.DataAccessException;

//DAO=Crud + connection object
public class BookDaoImpl implements BookDao {

	private Connection connection;

	public BookDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void addBook(Book book) {
		// isbn | title | author | pubDate | price
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("insert into books(isbn, title, author, pubDate, price) values (?,?,?,?,?)");
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setDate(4, new Date(book.getPubDate().getTime()));
			pstmt.setDouble(5, book.getPrice());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}

	}

	@Override
	public void deleteBook(int id) {
		Book book = getBookById(id).orElseThrow(() -> new BookNotFoundException("book with id:" + id + " is not fund"));

		try {
			PreparedStatement pstmt = connection.prepareStatement("delete from books where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}

	}

	@Override
	public void updateBook(int id, double price) {
		Book book = getBookById(id).orElseThrow(() -> new BookNotFoundException("book with id:" + id + " is not fund"));

		try {
			PreparedStatement pstmt = connection.prepareStatement("update books set price=? where id=?");
			pstmt.setDouble(1, price);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}
	}

	@Override
	public List<Book> getAllBooks() {
		// fist of all create a temp list
		// then the db, featch a tuple convert that to a book object
		// add that book object to taht list
		// return that list

		// id| isbn | title | author | pubDate | price
		List<Book> books = new ArrayList<>();
		Book book = null;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books");

			while (rs.next()) {
				// for a particular tuple we are converting that to java object, manually
				// but letter on we will learn a framework that is called hibernat taht can do
				// for us
				// ORM : object to relational mapping

				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getDate("pubDate"), rs.getDouble("price"));

				books.add(book);
			}

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc issue", e);
		}

		return books;
	}

	@Override
	public Optional<Book> getBookById(int id) {

		Book book = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from books where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {// rec is found
				book = new Book(id, rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getDate("pubDate"), rs.getDouble("price"));
			}

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}
		return Optional.ofNullable(book);
	}

	@Override
	public Optional<Book> getBookByIsbn(String isbn) {
		Book book = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from books where isbn=?");
			pstmt.setString(1, isbn);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {// rec is found
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getDate("pubDate"), rs.getDouble("price"));
			}

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem", e);
		}
		return Optional.ofNullable(book);
	}
}