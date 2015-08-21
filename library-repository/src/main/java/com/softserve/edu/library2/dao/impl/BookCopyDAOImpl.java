package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.BookCopyDAO;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dmytro on 8/20/2015.
 */
public class BookCopyDAOImpl extends AbstractDAO<BookCopy, Integer> implements BookCopyDAO{

    private static Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    @Override
    public List<BookCopy> findByName(String name) {
        String sql = "FROM  BookCopy WHERE book.name =:name";
        HibernateUtil.getSession().createQuery(sql).setString("name", name);
        Query query = HibernateUtil.getSession().createQuery(sql).setString("name", name);
        List<BookCopy> bookCopyList  = new ArrayList<BookCopy>();
        try {
            bookCopyList = findMany(query);
        } catch (Exception e) {
            logger.error("Error", e);
        }
        return bookCopyList;
    }

    @Override
    public List<BookCopy> findByBook(Book book) {
        String sql = "FROM  BookCopy WHERE book =:book";
        HibernateUtil.getSession().createQuery(sql);
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("book" ,book);
        List<BookCopy> bookCopyList  = new ArrayList<BookCopy>();
        try {
            bookCopyList = findMany(query);
        } catch (Exception e) {
            logger.error("Error", e);
        }
        return bookCopyList;

    }

}
