package com.softserve.edu.library2.dao.impl;

import java.util.*;

import com.softserve.edu.library2.dao.BookCopyReaderDAO;
import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.dao.entities.BookCopyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.BookCopyDAO;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;

/**
 * Created by Dmytro on 8/20/2015.
 */

@Repository
public class BookCopyDAOImpl extends AbstractDAO<BookCopy, Integer>implements BookCopyDAO {

	private static Logger logger = LogManager.getLogger();

	BookCopyReaderDAO bookCopyReaderDAO;

	@Override
	public List<BookCopy> findByName(String name) {
		String sql = "FROM  BookCopy WHERE book.name =:name";
		Query query = super.getSession().createQuery(sql).setString("name", name);
		List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
		try {
			bookCopyList = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return bookCopyList;
	}

	@Override
	public List<BookCopy> findByBook(Book book) {
		String sql = "FROM BookCopy  WHERE book.isbn =:isbn";
		Query query = super.getSession().createQuery(sql).setParameter("isbn", book.getIsbn());
		List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
		try {
			bookCopyList = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return bookCopyList;

	}

	@Override
	public List<BookCopy> findByReturningDate(Date date) {
		String sql = "FROM  BookCopy WHERE returningDate =:date";
		Query query = super.getSession().createQuery(sql).setParameter("date", date);
		List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
		try {
			bookCopyList = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return bookCopyList;

	}

	@Override
	public List<BookCopy> findByBorrowingDate(Date date) {
		String sql = "FROM  BookCopy WHERE borrowingDate =:date";
		Query query = super.getSession().createQuery(sql).setParameter("date", date);
		List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
		try {
			bookCopyList = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return bookCopyList;

	}

	@Override
	public List<BookCopy> findByPrecence(Character isPresent) {
		String sql = "FROM  BookCopy WHERE isPresent =:isPresent";
		Query query = super.getSession().createQuery(sql).setParameter("isPresent", isPresent);
		List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
		try {
			bookCopyList = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return bookCopyList;
	}

	@Override
	public List<BookCopy> findByISBN(Long isbn) {
		String sql;
		sql = "FROM  BookCopy WHERE book.isbn=:isbn";
		Query query = super.getSession().createQuery(sql).setParameter("isbn", isbn);
		List<BookCopy> bookCopyList = Collections.emptyList();
		try {
			bookCopyList = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		for (BookCopy bookCopy : bookCopyList) {
			Hibernate.initialize(bookCopy.getBook());
		}
		return bookCopyList;
	}

	@Override
	public Author findAuthorOfBookCopy(BookCopy bookCopy) {
		String sql;
		sql = "FROM Author WHERE authorId=:id";
		Query query = super.getSession().createQuery(sql).setParameter("id",
				bookCopy.getBook().getAuthor().getAuthorId());
		return new Author();
	}

	@Override
	public List<BookCopy> findAll() {
		List<BookCopy> books = Collections.emptyList();
		try {
			books = findAll(BookCopy.class);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		for (BookCopy bookCopy : books) {
			Hibernate.initialize(bookCopy.getBook());
		}
		return (List<BookCopy>) books;
	}
	@Override
	public void deleteById(Integer id) {
		if (id == null) {
			throw logger.throwing(new NullPointerException("Book copy id to delete is null"));
		}
		BookCopy bookCopy = findByID(BookCopy.class, id);
	//	Hibernate.initialize(bookCopy.getBookCopyReaders());
		if (bookCopy == null) {
			throw new EntityNotFoundException("Book copy not found for deleting");
		}
		//delete(bookCopy.getBookCopyReaders());

		delete(bookCopy);

	}

	@Override
	public BookCopy findByID(Integer id) {
		return findByID(id);
	}


}
