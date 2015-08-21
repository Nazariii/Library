/**
 * 
 */
package com.softserve.edu.library2.dao;

import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;

import java.util.List;

/**
 * @author Назік
 *
 */
public interface BookCopyDAO extends GenericDAO<BookCopy, Integer> {
    public List<BookCopy> findByName(String name);
    public List<BookCopy> findByBook(Book book);
}
