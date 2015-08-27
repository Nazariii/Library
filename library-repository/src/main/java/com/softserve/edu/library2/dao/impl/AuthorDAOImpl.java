/**
 * 
 */
package com.softserve.edu.library2.dao.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.AuthorDAO;
import com.softserve.edu.library2.dao.entities.Author;

/**
 * @author Назік
 *
 */
@Repository
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
		Query query = super.getSession().createQuery(sql).setString("firstName", firstName)
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
		Query query = super.getSession().createQuery(sql).setString("name", name);
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
		Query query = super.getSession().createQuery(sql).setString("name", name);
		List<Author> author = null;
		try {
			author = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return author;
	}

	@Override
	public void deleteById(Integer id) {
		if (id == null) {
			throw logger.throwing(new NullPointerException("Author id to delete is null"));
		}

		/*
		 * Criteria crit = createEntityCriteria();
		 * crit.add(Restrictions.eq("authorId", id)); Author author = (Author)
		 * crit.uniqueResult(); delete(author);
		 */
		Author author = findByID(Author.class, id);
		if (author == null) {
			throw new EntityNotFoundException("Author not found for deleting");
		}
		delete(author);

	}

}
