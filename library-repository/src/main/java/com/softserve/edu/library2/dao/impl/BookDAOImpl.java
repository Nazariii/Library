package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.BookDAO;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.util.HibernateUtil;

import org.apache.logging.log4j.Logger;
import org.hibernate.Query;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * @author Taras
 *
 */
public class BookDAOImpl extends AbstractDAO<Book, Integer> implements BookDAO {

	private static Logger logger = org.apache.logging.log4j.LogManager.getLogger();
	
	/**
	 * Method finds book by name
	 * 
	 * @param name
	 *            - name of book
	 * @return {@link Book}
	 */
	@Override
	public Book getBookByName(String name) {
		String sql = "FROM Book WHERE name = :name";
		Query query = HibernateUtil.getSession().createQuery(sql).setString("name", name);
		Book book = null;
		try {
			book = findOne(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return book;
	}
	
	/**
	 * Method finds book by isbn
	 * 
	 * @param isbn
	 *            - isbn of book
	 * @return {@link Book}
	 */
	@Override
	public Book getBookByISBN(long isbn) {
		String sql = "FROM Book WHERE isbn = :isbn";
		Query query = HibernateUtil.getSession().createQuery(sql).setLong("isbn", isbn);
		Book book = null;
		try {
			book = findOne(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return book;
	}

	
	/**
	 * Method finds all books published in {@param year}
	 * 
	 * @param year
	 *            - year of publishing
	 * @return {@link List<Book>}
	 */
	@Override
	public List<Book> getBooksByYear(int year) {
		if (year < 1700 || year > LocalDate.now().getYear()) {
			throw new IllegalArgumentException("Year must be in range [1700 - current year].");
		}
		
		String sql = "FROM Book WHERE year = :year";
		Query query = HibernateUtil.getSession().createQuery(sql).setInteger("year", year);
		List<Book> books = Collections.emptyList();
		try {
			books = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return books;
	}
	
	/**
	 * Method gets all books from database
	 * 
	 * @return {@link List<Book>}
	 */
	@Override
	public List<Book> getAllBooks() {	
		List<Book> books = Collections.emptyList();
		try {
			books = findAll(Book.class);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return books;
	}
	
	/**
	 * Method finds all books with specific author
	 * 
	 * @param firstName
	 *            - author's first name.
	 * @param lastName          
	 *  	      - author's last name.
	 *  
	 * @return {@link List<Book>}
	 */
	@Override
	public List<Book> getBooksByAuthor(String firstName, String lastName) {
		String sql = "FROM Book as book WHERE book.author.firstName = :firstName AND book.author.lastName = :lastName";
		Query query = HibernateUtil.getSession().createQuery(sql).setString("firstName", firstName)
				.setString("lastName", lastName);
		List<Book> books = Collections.emptyList();
		try {
			books = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return books;
	}

	
	/**
	 *  Method finds all books published by {@param publisher}
	 * 
	 * @param publisher
	 * 				- publisher
	 * @return {@link List<Book>}
	 */
	public List<Book> getBooksByPublisher(String publisher) {
		String sql = "FROM Book WHERE publication = :publisher";
		Query query = HibernateUtil.getSession().createQuery(sql).setString("publisher", publisher);
		List<Book> books = Collections.emptyList();
		try {
			books = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return books;
	}
	
}
