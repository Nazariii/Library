/**
 * 
 */
package com.softserve.edu.library2.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.dao.entities.BookCopyReader;

/**
 * @author Назік
 *
 */
public interface BookCopyDAO extends GenericDAO<BookCopy, Integer> {

	public List<BookCopy> findByName(String name);

	public List<BookCopy> findByBook(Book book);

	public List<BookCopy> findByReturningDate(Date date);

	public List<BookCopy> findByBorrowingDate(Date date);

	public List<BookCopy> findByPrecence(Character isPresent);

	public List<BookCopy> findByISBN(Long isbn);

	public Author findAuthorOfBookCopy (BookCopy bookCopy);

	public List<BookCopy> findAll();

	public void deleteById(Integer id);

	public void merge(BookCopy bookCopy);
}
