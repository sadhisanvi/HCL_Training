package com.bookapp.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class BookDaoImplHibernate implements BookDao{
	
	private SessionFactory factory;
	
	@Autowired
	public BookDaoImplHibernate(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();        
	}

	@Override
	public List<Book> getAllBooks() {
		return getSession().createQuery("from Book").getResultList();
	}

	@Override
	public Book addBook(Book book) {
		getSession().save(book);
		return book;
	}

	@Override
	public void deleteBook(int id) {
		Book book = getBookById(id);
		getSession().delete(book);
		
	}

	@Override
	public void updateBook(int id, Book book) {
		Book bookToUpdate = getBookById(id);
		bookToUpdate.setPrice(book.getPrice());
		getSession().update(bookToUpdate);
		
	}

	@Override
	public Book getBookById(int id) {
		Query query = getSession().createQuery("select b from Book b where id=:id1");
		query.setParameter("id1", id);
		Book book = (Book) query.getSingleResult();
		return book;
	}
	
	

}
