/**
 * 
 */
package com.softserve.edu.library2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.edu.library2.dao.BookDAO;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.service.BookService;

/**
 * @author Taras
 *
 */
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO bookDAO;

	@Override
	@Transactional
	public Book getBookByName(String name) {
		return bookDAO.getBookByName(name);
	}

	@Override
	@Transactional
	public Book getBookByISBN(long isbn) {
		return bookDAO.getBookByISBN(isbn);
	}

	@Override
	@Transactional
	public List<Book> getBooksByYear(int year) {
		return bookDAO.getBooksByYear(year);
	}

	
	@Override
	@Transactional
	public List<Book> getAllBooks() {
		return bookDAO.getAllBooks();
	}
	
	@Override
	@Transactional
	public List<Book> getBooksByAuthor(String firstName, String lastName) {
		return bookDAO.getBooksByAuthor(firstName, lastName);
	}

	@Override
	@Transactional
	public List<Book> getBooksByPublisher(String publisher) {
		return bookDAO.getBooksByPublisher(publisher);
	}

	@Override
	@Transactional
	public List<Book> getBooksByReader(String firstName, String lastName) {
		return bookDAO.getBooksByReader(firstName, lastName);
	}

}
