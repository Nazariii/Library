package com.softserve.edu.library2.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
	private final static int BOOK_YEAR = 1750;
	private final static String BOOK_PUBLISHER = "O'Reilly";
	
	private static Book book = new Book(BOOK_ISBN, BOOK_NAME, 3);
	private static BookDAOImpl bookDAOImpl = new BookDAOImpl();
	
	@Ignore
	@Before
	public void setUp() {	
		book.setYear(BOOK_YEAR);
		book.setPublication(BOOK_PUBLISHER);
		
		HibernateUtil.beginTransaction();
		bookDAOImpl.save(book);
		HibernateUtil.commitTransaction();
	}

	@Ignore
	@After
	public void tearDown() {
		HibernateUtil.beginTransaction();
		bookDAOImpl.delete(book);
		HibernateUtil.commitTransaction();
	}
	
	@Ignore
	@Test 
	public void testGetBookByName() {
		HibernateUtil.beginTransaction();
		Book resultBook = bookDAOImpl.getBookByName(BOOK_NAME);
		HibernateUtil.commitTransaction();
		
		assertEquals(book, resultBook);
	}
	
	@Ignore
	@Test 
	public void testGetBookByISBN() {
		HibernateUtil.beginTransaction();
		Book resultBook = bookDAOImpl.getBookByISBN(BOOK_ISBN);
		HibernateUtil.commitTransaction();
		
		assertEquals(book, resultBook);
	}
	
	@Ignore
	@Test
	public void testGetBooksByYear() {
		HibernateUtil.beginTransaction();
		List<Book> books = bookDAOImpl.getBooksByYear(BOOK_YEAR);
		HibernateUtil.commitTransaction();
		
		assertTrue(books.contains(book));
		
	}
	
	@Ignore
	@Test
	public void testGetAllBooks() {
		HibernateUtil.beginTransaction();
		List<Book> books = bookDAOImpl.getAllBooks();
		HibernateUtil.commitTransaction();
		
		assertTrue(books.contains(book));
	}
	
	@Ignore
	@Test
	public void testGetBooksByAuthor() {
		final String firstName = "Ivan";
		final String lastName = "Franko";
		final String bookName = "Kamenyari";
		
		HibernateUtil.beginTransaction();
		List<Book> books = bookDAOImpl.getBooksByAuthor(firstName, lastName);
		HibernateUtil.commitTransaction();
		
		assertTrue(books.size() > 0 && books.get(0).getName().equals(bookName));
	}
	
	@Ignore
	@Test
	public void testGetBooksByPublisher() {
		HibernateUtil.beginTransaction();
		List<Book> books = bookDAOImpl.getBooksByPublisher(BOOK_PUBLISHER);
		HibernateUtil.commitTransaction();
		
		assertTrue(books.contains(book));
	}
	
	@Ignore
	@Test
	public void testGetBooksByReader() {
		final String firstName = "Petro";
		final String lastName = "Las";
		final String bookName = "Kamenyari";
		
		HibernateUtil.beginTransaction();
		List<Book> books = bookDAOImpl.getBooksByReader(firstName, lastName);
		HibernateUtil.commitTransaction();
		
		assertTrue(books.size() > 0 && books.get(0).getName().equals(bookName));
	}
	
}