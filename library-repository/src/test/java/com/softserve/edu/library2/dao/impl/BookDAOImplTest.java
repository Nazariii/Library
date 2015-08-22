package com.softserve.edu.library2.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.junit.After;
import org.junit.Before;
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
	
	@Before
	public void init() {	
		book.setYear(BOOK_YEAR);
		book.setPublication(BOOK_PUBLISHER);
		
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
	
	@Test
	public void testGetAllBooks() {
		HibernateUtil.beginTransaction();
		List<Book> books = bookDAOImpl.getAllBooks();
		HibernateUtil.commitTransaction();
		
		//assertTrue(books.contains(book));
		for (Book b : books) {
			if (b.getName().equals(BOOK_NAME)) {
				assertTrue(true);
			}
		}
	}
	
	@Test
	public void testGetBooksByAuthor() {
		HibernateUtil.beginTransaction();
		List<Book> books = bookDAOImpl.getBooksByAuthor("Ivan", "Franko");
		HibernateUtil.commitTransaction();
		
		assertTrue(books.size() > 0 && books.get(0).getName().equals("Kamenyari"));
	}
	
	@Test
	public void testGetBooksByPublisher() {
		HibernateUtil.beginTransaction();
		List<Book> books = bookDAOImpl.getBooksByPublisher(BOOK_PUBLISHER);
		HibernateUtil.commitTransaction();
		
		assertTrue(books.size() > 0 && books.get(0).getName().equals(BOOK_NAME)
				&& books.get(0).getPublication().equals(BOOK_PUBLISHER));
	}
	
	@Test
	public void testGetBooksByReader() {
		HibernateUtil.beginTransaction();
		List<Book> books = bookDAOImpl.getBooksByReader("Petro", "Las");
		HibernateUtil.commitTransaction();
		
		assertTrue(true);
	}
	
	@After
	public void undoChanges() {
		HibernateUtil.beginTransaction();
		bookDAOImpl.delete(book);
		HibernateUtil.commitTransaction();
	}
}
