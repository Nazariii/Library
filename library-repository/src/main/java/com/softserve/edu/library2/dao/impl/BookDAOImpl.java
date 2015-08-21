package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.BookDAO;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Vova
 *
 */
public class BookDAOImpl extends AbstractDAO<Book, Integer> implements BookDAO {
        private Class book;
        private Long id;

        public void updateBook(Long book_id, Book book) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(book);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }


        public Collection getAllBooks() throws SQLException {
            Session session = null;
            List books = new ArrayList<Book>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                books = session.createCriteria(Book.class).list();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return books;
        }

        public void deleteBook(Book book) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(book);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        @Override
        public void save(Book entity) {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(entity);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        @Override
        public void merge(Book entity) {

        }

        @Override
        public void delete(Book entity) {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(book);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
}
