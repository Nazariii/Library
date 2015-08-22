/**
 * 
 */
package com.softserve.edu.library2.dao;

import java.util.List;

import com.softserve.edu.library2.dao.entities.Book;

/**
 * @author Taras
 *
 */
public interface BookDAO extends GenericDAO<Book, Integer>{
	Book getBookByName(String name);
	Book getBookByISBN(long isbn);
	List<Book> getBooksByYear(int year);
	List<Book> getAllBooks();
	List<Book> getBooksByAuthor(String firstName, String lastName);
	List<Book> getBooksByPublisher(String publisher);
}
