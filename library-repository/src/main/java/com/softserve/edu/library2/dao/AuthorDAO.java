/**
 * 
 */
package com.softserve.edu.library2.dao;

import com.softserve.edu.library2.dao.entities.Author;

/**
 * @author Назік
 *
 */
public interface AuthorDAO extends GenericDAO<Author, Integer> {
	public Author findByName(String firstName, String lastName);

}