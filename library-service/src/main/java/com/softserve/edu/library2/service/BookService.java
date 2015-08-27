package com.softserve.edu.library2.service;

import java.util.List;

import com.softserve.edu.library2.dao.entities.Book;

public interface BookService {
	Book getBookByName(String name);
	
	Book getBookByISBN(long isbn);
	
	List<Book> getBooksByYear(int year);
	
	List<Book> getAllBooks();
	
	List<Book> getBooksByAuthor(String firstName, String lastName);
	
	List<Book> getBooksByPublisher(String publisher);
	
	List<Book> getBooksByReader(String firstName, String lastName);
}
