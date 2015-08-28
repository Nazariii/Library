/**
 * 
 */
package com.softserve.edu.library2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.softserve.edu.library2.dao.entities.Author;

/**
 * @author Назік
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Integer> {

	public Author findByLastName(String lastName);
	
	public Author findByFirstNameAndLastName(String firstName, String lastName);

	@Query("SELECT author FROM Author AS author JOIN author.book AS book WHERE name LIKE ?1")
	public Author findByBookName(String name);

	@Query("SELECT DISTINCT author FROM Author author JOIN author.bookauthors AS subauthors WHERE subauthors.name LIKE ?1")
	public List<Author> findSubauthorByBook(String name);

	public void deleteByauthorId(Integer authorId);
	
	public Author findByauthorId(Integer authorId);
}
