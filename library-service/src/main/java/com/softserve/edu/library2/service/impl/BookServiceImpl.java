/**
 * 
 */
package com.softserve.edu.library2.service.impl;

import java.util.List;

import com.softserve.edu.library2.dao.entities.BookCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.edu.library2.dao.BookDAO;
import com.softserve.edu.library2.dao.entities.Author;
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
	public void save(Book book) {
		bookDAO.save(book);
	}
	
	@Override
	@Transactional
	public void update(Book book) {
		Book oldBook = getBookByISBN(book.getIsbn());
		if (oldBook != null) {
			oldBook.setName(book.getName());
			oldBook.setPublication(book.getPublication());
			oldBook.setYear(book.getYear());
			oldBook.setPageCount(book.getPageCount());
		} else {
			save(book);
		}
	}
	
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
	public List<Book> getBooksByAuthorId(Integer id) {
		return bookDAO.getBooksByAuthorId(id);
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

	@Override
	@Transactional
	public void deleteByIsbn(long isbn) {
		for (int i = 0; i < 10; ++i) {
			System.out.println(isbn);
		}
		bookDAO.deleteByIsbn(isbn);
	}

}
