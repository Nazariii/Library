package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.BookDAO;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.util.HibernateUtil;

import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * @author Taras
 *
 */
@Repository
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
		Query query = super.getSession().createQuery(sql).setString("name", name);
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
		Query query = super.getSession().createQuery(sql).setLong("isbn", isbn);
		Book book = null;
		try {
			book = findOne(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return book;
	}

	/**
	 * Method finds all books published in
	 * 
	 * @param year}
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
		Query query = super.getSession().createQuery(sql).setInteger("year", year);
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
		for (Book book : books) {
			Hibernate.initialize(book.getAuthor());
		}
		return books;
	}

	/**
	 * Method finds all books with specific author
	 * 
	 * @param firstName
	 *            - author's first name.
	 * @param lastName
	 *            - author's last name.
	 * 
	 * @return {@link List<Book>}
	 */
	@Override
	public List<Book> getBooksByAuthor(String firstName, String lastName) {
		String sql = "FROM Book as book WHERE book.author.firstName = :firstName AND book.author.lastName = :lastName";
		Query query = super.getSession().createQuery(sql).setString("firstName", firstName)
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
	 * Method finds all books published by {@param publisher}
	 * 
	 * @param publisher
	 *            - publisher
	 * @return {@link List<Book>}
	 */
	@Override
	public List<Book> getBooksByPublisher(String publisher) {
		String sql = "FROM Book WHERE publication = :publisher";
		Query query = super.getSession().createQuery(sql).setString("publisher", publisher);
		List<Book> books = Collections.emptyList();
		try {
			books = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return books;
	}
	
	/**
	 * Method finds all books by reader.
	 * 
	 * @param firstName
	 * 				- reader's first name.
	 * 
	 * @param lastName 
	 * 				- reader's last name.
	 * 
	 * @return {@link List<Book>}
	 */
	@Override
	public List<Book> getBooksByReader(String firstName, String lastName) {
		String sql = "SELECT bcr.book FROM BookCopyReader as bcr WHERE bcr.reader.firstName = :firstName "
				+ "AND bcr.reader.lastName = :lastName";
		//String sql = "FROM Book as book JOIN bookCopyReaders as bcr WHERE bcr.reader.firstName = :firstName "
		//		+ "AND bcr.reader.lastName = :lastName";
		Query query = super.getSession().createQuery(sql).setString("firstName", firstName)
				.setString("lastName", lastName);
		List<Book> books = Collections.emptyList();
		try {
			books = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return books;
	}

}
