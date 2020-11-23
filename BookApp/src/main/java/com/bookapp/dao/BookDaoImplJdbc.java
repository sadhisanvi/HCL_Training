package com.bookapp.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.bookapp.dao.exceptions.BookNotFoundException;
import com.bookapp.dao.exceptions.DataAccessException;

@Primary
@Repository
public class BookDaoImplJdbc implements BookDao {

	private DataSource dataSource;
	
	public BookDaoImplJdbc() {
		
	}
	
	@Autowired
	public BookDaoImplJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		Book book = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books");
			while (rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getDouble("price"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void addBook(Book book) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("insert into books(isbn,title, author, price) values (?,?,?,?)");
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setDouble(4, book.getPrice());
			int i = pstmt.executeUpdate();
			System.out.println(i +" records inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteBook(int id) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("delete from books where id=?");
			pstmt.setInt(1, id);
			int i = pstmt.executeUpdate("delete * from books where id=id");
			System.out.println(i +" records removed");

		} catch (SQLException e) {
			throw new DataAccessException("some jdbc problem");
		}
	}

	@Override
	public void updateBook(int id, Book book) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update books set price=? where id=?");
			pstmt.setDouble(1, book.getPrice());
			pstmt.setInt(2, id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Book getBookById(int id) {
		Connection connection;
		Book book = null;

		try {
			
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books where id=id");
			if (rs.next()) {
				book = new Book(id, rs.getString("isbn"), rs.getString("title"), rs.getString("author"),
						rs.getDouble("price"));
			} else {
				throw new BookNotFoundException("account with id =" + id + " is not found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}

}
