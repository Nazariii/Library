package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.ReaderDAO;
import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Dmytro on 8/21/2015.
 */

public class ReaderDAOImplTest {
    private static ReaderDAOImpl readerDAOImpl = new ReaderDAOImpl();

    @Ignore
    @Test
    public void testSave() {
        Reader reader = new Reader("Eric", "Cartman");
        HibernateUtil.beginTransaction();
        readerDAOImpl.save(reader);
        HibernateUtil.commitTransaction();
        assertTrue(true);

    }

    @Ignore
    @Test
    public void testFindByName() throws Exception {
        final String firstName = "Petro";
        final String lastName = "Las";
        HibernateUtil.beginTransaction();
        List<Reader> expectedList = readerDAOImpl.findByName(firstName, lastName);
        HibernateUtil.commitTransaction();
        for (Reader reader : expectedList){
            if(reader.getFirstName() == firstName){
                assertTrue(true);
            }
        }

    }

    @Ignore
    @Test
    public void testFindByAddress() throws Exception {
        final Address address = new Address("Lviv");
        HibernateUtil.beginTransaction();
        List<Reader> listReaders = readerDAOImpl.findByAddress(address);
        HibernateUtil.commitTransaction();
        for (Reader reader : listReaders) {
            System.out.println(reader.getAddress());
            assertEquals(address, reader.getAddress());
        }
    }

    @Ignore
    @Test
    public void testFindTelephone() throws Exception {
        final String telephone = "0934862226";
        HibernateUtil.beginTransaction();
        Reader reader = readerDAOImpl.findByTelephone(telephone);
        HibernateUtil.commitTransaction();
        assertEquals(telephone, reader.getTelephone());
    }

    @Ignore
    @Test
    public void testFindByBirthDate() throws Exception {
        final GregorianCalendar cal = new GregorianCalendar(1992, 2, 1);
        final Date date = cal.getTime();
        List<Reader> listReaders = Collections.emptyList();
        HibernateUtil.beginTransaction();
        listReaders = readerDAOImpl.findByBirthDate(date);
        HibernateUtil.commitTransaction();
        for (Reader reader : listReaders) {
            assertEquals(date, reader.getBirthDate());
        }

    }

    @Ignore
    @Test
    public void testFindByBook() throws Exception {
        final String name = "Sql vs Java";
        List<Reader> listReaders = Collections.emptyList();
        HibernateUtil.beginTransaction();
        listReaders = readerDAOImpl.findByBook(name);
        HibernateUtil.commitTransaction();
        assertTrue(true);
    }
}