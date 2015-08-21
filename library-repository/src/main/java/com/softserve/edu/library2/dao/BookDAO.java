/**
 * 
 */
package com.softserve.edu.library2.dao;

import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;

/**
 * @author Taras
 *
 */
public interface BookDAO extends GenericDAO<Book, Integer>{
	Book getBookByName(String name);
	Book getBookByISBN(long isbn);
	//List<Book> getBooksByYear(Date year);
}
