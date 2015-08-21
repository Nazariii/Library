package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.dao.entities.BookCopyReader;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.hibernate.Query;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by vova on 21.08.15.
 */
public class BookCopyDAOImplTest {
    static BookCopyDAOImpl bookCopyDAO = new BookCopyDAOImpl();
    static BookDAOImpl bookDAOImpl = new BookDAOImpl();

    private final static String BOOK_NAME = "Hibernate 4 dummies";
    private final static long BOOK_ISBN = 1234567891123L;
    private static Book book = new Book(BOOK_ISBN, BOOK_NAME, 3);
    private final static Character  isPresent = 'Y';
    private final static Date returningDate = new Date();
    private final static Date borrowingDate = new Date();
    private final static Set< BookCopyReader > bookCopyReaders = new HashSet<BookCopyReader>();
    private  BookCopy bookCopy = new BookCopy(book, isPresent, returningDate, borrowingDate,
             bookCopyReaders);


    @Before
    public void init() {
        // book.setYear(BOOK_YEAR);
        HibernateUtil.beginTransaction();
        bookDAOImpl.save(book);
        HibernateUtil.commitTransaction();
        HibernateUtil.beginTransaction();
        bookCopyDAO.save(bookCopy);
        HibernateUtil.commitTransaction();
    }

    @Test
    public void testFindByName() throws Exception {
        String sql = "FROM  BookCopy WHERE book.name =:Name";
        String name = "name";
        HibernateUtil.beginTransaction();
        List<BookCopy> expectedBookCopyList = bookCopyDAO.findByName(name);
        Query query = HibernateUtil.getSession().createQuery(sql).setString("Name" ,name);
        List<BookCopy> actualBookCopyList = bookCopyDAO.findMany(query);
        HibernateUtil.commitTransaction();
        assertEquals(expectedBookCopyList, actualBookCopyList);

        HibernateUtil.beginTransaction();
        List<BookCopy> resultBook = bookCopyDAO.findByName(book.getName());
        HibernateUtil.commitTransaction();
        assertTrue(resultBook.equals(actualBookCopyList));
    }

    @Test
    public void testFindByBook() throws Exception {
        String sql = "FROM  BookCopy WHERE book =:book";
        Book book = new Book();
        HibernateUtil.beginTransaction();
        List<BookCopy> expectedBookCopyList = bookCopyDAO.findByBook(book);
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("book", book);
        List<BookCopy> actualBookCopyList = bookCopyDAO.findMany(query);
        HibernateUtil.commitTransaction();
        assertEquals(expectedBookCopyList, actualBookCopyList);
    }

    @Test
    public void testFindByReturningDate() throws Exception {
        String sql = "FROM  BookCopy WHERE book =:book";
        Book book = new Book();
        HibernateUtil.beginTransaction();
        List<BookCopy> expectedBookCopyList = bookCopyDAO.findByBook(book);
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("book", book);
        List<BookCopy> actualBookCopyList = bookCopyDAO.findMany(query);
        HibernateUtil.commitTransaction();
        assertEquals(expectedBookCopyList, actualBookCopyList);
    }

}