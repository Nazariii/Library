package com.softserve.edu.library2.dao.impl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.YesNoType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.util.HibernateUtil;

//TODO: Change asserts when equals will be overridden.
/*
 * @author Taras
 */
public class BookDAOImplTest {
	private final static String BOOK_NAME = "Hibernate 4 dummies";
	private final static long BOOK_ISBN = 1234567891123L;
	//private final static Date BOOK_YEAR = new Date(2009, 3, 5);
	
	private static Book book = new Book(BOOK_ISBN, BOOK_NAME, 3);
	private static BookDAOImpl bookDAOImpl = new BookDAOImpl();
	
	@Before
	public void init() {	
		// book.setYear(BOOK_YEAR);
		HibernateUtil.beginTransaction();
		bookDAOImpl.save(book);
		HibernateUtil.commitTransaction();
	}

	@Test 
	public void testGetBookByName() {
		HibernateUtil.beginTransaction();
		Book resultBook = bookDAOImpl.getBookByName(BOOK_NAME);
		HibernateUtil.commitTransaction();
		
		assertTrue(resultBook.getName().equals(BOOK_NAME)
				&& resultBook.getIsbn() == book.getIsbn());		
	}
	
	@Test 
	public void testGetBookByISBN() {
		HibernateUtil.beginTransaction();
		Book resultBook = bookDAOImpl.getBookByISBN(BOOK_ISBN);
		HibernateUtil.commitTransaction();
		
		assertTrue(resultBook.getName().equals(BOOK_NAME)
				&& resultBook.getIsbn() == book.getIsbn());		
	}
	
	/*
	@Test
	public void testGetBooksByYear() {
		List<Book> expected = new ArrayList<Book>();
		expected.add(book);
		
		HibernateUtil.beginTransaction();
		List<Book> books = bookDAOImpl.getBooksByYear(BOOK_YEAR);
		HibernateUtil.commitTransaction();
		
		assertTrue(expected.size() == books.size()
				&& expected.get(0).getIsbn() == books.get(0).getIsbn());
		
	}
	*/
	
	@After
	public void undoChanges() {
		HibernateUtil.beginTransaction();
		bookDAOImpl.delete(book);
		HibernateUtil.commitTransaction();
	}
}
