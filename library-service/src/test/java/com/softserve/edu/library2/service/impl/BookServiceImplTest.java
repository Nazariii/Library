package com.softserve.edu.library2.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.softserve.edu.library2.config.AppConfig;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.service.BookService;

public class BookServiceImplTest {
	
	private static AbstractApplicationContext context;
	private static BookService bookService;	
	
	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		bookService = (BookService) context.getBean("bookServiceImpl");
	}


	@Test
	public void testGetBookByName() {
		final String bookName = "Kobzar";
		
		Book book = bookService.getBookByName(bookName);
		
		assertEquals(bookName, book.getName());
	}

	@Test
	public void testGetBookByISBN() {
		final long bookIsbn = 1;
		
		Book book = bookService.getBookByISBN(bookIsbn);
		
		assertEquals(bookIsbn, book.getIsbn());
	}

	@Test
	public void testGetBooksByYear() {
		final int bookYear = 2009;
		
		List<Book> books = bookService.getBooksByYear(bookYear);
		
		assertTrue(books.size() > 0 
				&& bookYear == books.get(0).getYear());
	}

	@Test
	public void testGetAllBooks() {
		List<Book> books = bookService.getAllBooks();
		
		assertTrue(books.size() > 0);
	}

	@Test
	public void testGetBooksByAuthor() {
		final String firstName = "Ivan";
		final String lastName = "Franko";
		final String bookName = "Kamenyari";
		
		List<Book> books = bookService.getBooksByAuthor(firstName, lastName);
		
		assertTrue(books.size() > 0 && books.get(0).getName().equals(bookName));
	}

	@Test
	public void testGetBooksByPublisher() {
		final String publisher = "Kolobok";
		final String bookName = "Kamenyari";
		
		List<Book> books = bookService.getBooksByPublisher(publisher);
		
		assertTrue(books.size() > 0 && books.get(0).getName().equals(bookName));
	}

	@Test
	public void testGetBooksByReader() {
		final String firstName = "Petro";
		final String lastName = "Las";
		final String bookName = "Kamenyari";
		
		List<Book> books = bookService.getBooksByReader(firstName, lastName);
		Book b = books.get(0);
		assertTrue(books.size() > 0 && b.getName().equals(bookName));	
	}

}
