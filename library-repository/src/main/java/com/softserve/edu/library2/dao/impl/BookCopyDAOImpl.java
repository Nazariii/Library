package com.softserve.edu.library2.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.softserve.edu.library2.dao.entities.Author;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.BookCopyDAO;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmytro on 8/20/2015.
 */

@Repository
public class BookCopyDAOImpl extends AbstractDAO<BookCopy, Integer> implements BookCopyDAO {

	private static Logger logger = LogManager.getLogger();

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
		List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
		try {
			bookCopyList = findMany(query);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return bookCopyList;
	}

	@Override
	public Author findAuthorOfBookCopy(BookCopy bookCopy) {
		String sql;
		sql = "FROM Author WHERE authorId=:id";
		Query query = super.getSession().createQuery(sql).setParameter("id", bookCopy.getBook().getAuthor().getAuthorId());
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
	/*	for (BookCopy bookCopy : books) {
			Hibernate.initialize(bookCopy.getBook());
			                 <!--   <td>${bookcopy.book.name}</td> -->
			                             <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${bookcopies}" var="bookcopy">
                <tr>
                    <td>${bookcopy.isPresent}</td>
                    <td>${bookcopy.borrowingDate}</td>
                </tr>
            </c:forEach>
		}*/
		return (List<BookCopy>) books;
	}
}
