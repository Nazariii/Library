/**
 * 
 */
package com.softserve.edu.library2.service;

import java.util.List;

import com.softserve.edu.library2.dao.entities.Author;

/**
 * @author Назік
 *
 */
public interface AuthorService {

	public Author findByName(String firstName, String lastName);

	public Author findByBook(String name);

	public List<Author> findSubauthorByBook(String name);

	public Author findById(Integer id);

	public void save(Author author);

	public void update(Author author);
	
	public List<Author> findAll();
}
