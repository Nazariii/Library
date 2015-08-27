package com.softserve.edu.library2.service;

import java.util.List;

import com.softserve.edu.library2.dao.entities.Book;

public interface BookService {
	void save(Book book);
	
	void deleteByIsbn(long isbn);
	
	void update(Book book);
	
	Book getBookByName(String name);
	
	Book getBookByISBN(long isbn);
	
	List<Book> getBooksByYear(int year);
	
	List<Book> getAllBooks();
	
	List<Book> getBooksByAuthor(String firstName, String lastName);
	
	List<Book> getBooksByAuthorId(Integer id);
	
	List<Book> getBooksByPublisher(String publisher);
	
	List<Book> getBooksByReader(String firstName, String lastName);
}
