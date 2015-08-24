package com.softserve.edu.library2.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.BookCopyDAO;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.dao.util.HibernateUtil;

/**
 * Created by Dmytro on 8/20/2015.
 */
public class BookCopyDAOImpl extends AbstractDAO<BookCopy, Integer> implements BookCopyDAO {

	private static Logger logger = LogManager.getLogger();

	@Override
	public List<BookCopy> findByName(String name) {
		String sql = "FROM  BookCopy WHERE book.name =:name";
		HibernateUtil.getSession().createQuery(sql).setString("name", name);
		Query query = HibernateUtil.getSession().createQuery(sql).setString("name", name);
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
		String sql = "FROM  BookCopy  WHERE book.isbn =:isbn";
		HibernateUtil.getSession().createQuery(sql);
		Query query = HibernateUtil.getSession().createQuery(sql).setParameter("isbn", book.getIsbn());
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
		HibernateUtil.getSession().createQuery(sql);
		Query query = HibernateUtil.getSession().createQuery(sql).setParameter("date", date);
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
		HibernateUtil.getSession().createQuery(sql);
		Query query = HibernateUtil.getSession().createQuery(sql).setParameter("date", date);
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
		HibernateUtil.getSession().createQuery(sql);
		Query query = HibernateUtil.getSession().createQuery(sql).setParameter("isPresent", isPresent);
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
		HibernateUtil.getSession().createQuery(sql);
		Query query = HibernateUtil.getSession().createQuery(sql).setParameter("isbn", isbn);
		List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
		try {
			bookCopyList = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return bookCopyList;
	}

}
