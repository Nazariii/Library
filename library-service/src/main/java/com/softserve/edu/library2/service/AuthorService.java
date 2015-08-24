/**
 * 
 */
package com.softserve.edu.library2.service;

import com.softserve.edu.library2.dao.entities.Author;

/**
 * @author Назік
 *
 */
public interface AuthorService {
	
	public Author findByName(String firstName, String lastName);

}
