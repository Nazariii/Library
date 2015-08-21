/**
 * 
 */
package com.softserve.edu.library2.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.Query;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.AuthorDAO;
import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.dao.util.HibernateUtil;

/**
 * @author Назік
 *
 */
public class AuthorDAOImpl extends AbstractDAO<Author, Integer> implements AuthorDAO {

	private static Logger logger = org.apache.logging.log4j.LogManager.getLogger();

	/**
	 * Method finds author by first name and last name
	 * 
	 * @param firstName
	 *            - firstName of author
	 * @param lastName
	 *            - lastName of author
	 * @return {@link Author}
	 */
	public Author findByName(String firstName, String lastName) {
		String sql = "FROM Author WHERE firstName = :firstName AND lastName = :lastName";
		Query query = HibernateUtil.getSession().createQuery(sql).setString("firstName", firstName)
				.setString("lastName", lastName);
		Author author = null;
		try {
			author = findOne(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return author;
	}

	/**
	 * Takes name off the book and returns author of it
	 * 
	 * @param name
	 *            - name of book
	 * @return {@link Author} - author of the book
	 */
	@Override
	public Author findByBook(String name) {
		String sql = "SELECT author FROM Author AS author JOIN author.book AS book WHERE name LIKE :name";
		Query query = HibernateUtil.getSession().createQuery(sql).setString("name", name);
		Author author = null;
		try {
			author = findOne(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return author;
	}

	@Override
	public List<Author> findSubauthorByBook(String name) {
		String sql = "SELECT DISTINCT author FROM Author author JOIN author.bookauthors AS subauthors WHERE subauthors.name LIKE :name";
		Query query = HibernateUtil.getSession().createQuery(sql).setString("name", name);
		List<Author> author = null;
		try {
			author = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return author;
	}
}
