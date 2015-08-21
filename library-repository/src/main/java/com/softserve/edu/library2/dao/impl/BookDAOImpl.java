package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.BookDAO;
import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.util.HibernateUtil;

import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;
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
	 *
	@Override
	public List<Book> getBooksByYear(Date year) {
		String sql = "FROM Book WHERE year = :year";
		Query query = HibernateUtil.getSession().createQuery(sql).setInteger("year", year.getYear());
		List<Book> books = Collections.emptyList();
		try {
			books = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return books;
	}

	*/
}
