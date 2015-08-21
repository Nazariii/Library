package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.hibernate.Query;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vova on 21.08.15.
 */
public class BookCopyDAOImplTest {
    static BookCopyDAOImpl bookCopyDAO = new BookCopyDAOImpl();
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
    }


}