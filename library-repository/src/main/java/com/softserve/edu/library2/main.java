package com.softserve.edu.library2;

import com.softserve.edu.library2.dao.BookCopyDAO;
import com.softserve.edu.library2.dao.BookDAO;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.dao.impl.BookCopyDAOImpl;
import com.softserve.edu.library2.dao.impl.BookDAOImpl;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import com.softserve.edu.library2.repository.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created by vova on 23.08.15.
 */
public class main {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        BookCopyDAO bookCopyDAOImpl = new BookCopyDAOImpl();
        BookDAO bookDAOImpl = new BookDAOImpl();
            List<Book> books = bookDAOImpl.findAll(Book.class);
            Book book = books.get(0);
            List<BookCopy> bookCopyList = bookCopyDAOImpl.findByBook(book);
            System.out.println(bookCopyList.get(0));
    }
}
