package com.softserve.edu.library2.service.impl;

import com.softserve.edu.library2.config.AppConfig;
import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.service.ReaderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dmytro on 8/25/2015.
 */
public class ReaderServiceImplTest {

    AbstractApplicationContext context;
    ReaderService readerService;

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        readerService = (ReaderService) context.getBean("readerServiceImpl");

    }

    @Test
    public void testFindByName() throws Exception {
        List<Reader> listReaders = readerService.findByName("Kate", "Bush");
        assertEquals("Kate", listReaders.get(0).getFirstName());
    }

    @Test
    public void testFindByAddress() throws Exception {
        final Address address = new Address("Lviv");
        List<Reader> listReaders = readerService.findByAddress(address);
        for (Reader reader : listReaders) {
            System.out.println(reader.getAddress());
            assertEquals(address, reader.getAddress());
        }
    }

    @Test
    public void testFindByTelephone() throws Exception {
        final String telephone = "0934862226";
        Reader reader = readerService.findByTelephone(telephone);
        assertEquals(telephone, reader.getTelephone());
    }

    @Test
    public void testFindByBirthDate() throws Exception {
        final GregorianCalendar cal = new GregorianCalendar(1992, 2, 1);
        final Date date = cal.getTime();
        List<Reader> listReaders = readerService.findByBirthDate(date);
        for (Reader reader : listReaders) {
            assertEquals(date, reader.getBirthDate());
        }
    }

    @Test
    public void testFindByBook() throws Exception {
        final String name = "Sql vs Java";
        List<Reader> listReaders = readerService.findByBook(name);
        for (Reader reader : listReaders) {
            String fistName = reader.getFirstName();
            assertTrue(fistName.equals("Kate") || fistName.equals("Pavlo"));
        }
    }
}