/**
 * 
 */
package com.softserve.edu.library2.dao;

import java.sql.Date;
import java.util.List;

import com.softserve.edu.library2.dao.entities.Book;

/**
 * @author Taras
 *
 */
public interface BookDAO extends GenericDAO<Book, Integer>{
	Book getBookByName(String name);
	Book getBookByISBN(long isbn);
	//List<Book> getBooksByYear(Date year);
}
