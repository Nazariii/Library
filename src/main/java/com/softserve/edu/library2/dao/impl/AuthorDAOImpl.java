/**
 * 
 */
package com.softserve.edu.library2.dao.impl;

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

	/**
	 * Method finds author by first name and last name
	 */
	public Author findByName(String firstName, String lastName) {
		String sql = "FROM Author WHERE firstName = :firstName AND lastName = :lastName";
		Query query = HibernateUtil.getSession().createQuery(sql).setString("firstName", firstName)
				.setString("lastName", lastName);
		Author person = findOne(query);
		return person;
	}
	

}
