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

    @Test
    public void testFindByAddress1() throws Exception {
        final String city = "Lviv";
        List<Reader> listReaders = readerService.findByAddress(city);
        assertEquals(4, listReaders.size());
    }

    @Test
    public void testFindByAddress2() throws Exception {
        final String city = "Lviv";
        final String region = "Lviv";
        List<Reader> listReaders = readerService.findByAddress(city, region);
    assertEquals(4, listReaders.size());
}

    @Test
    public void testFindByAddress3() throws Exception {
        final String city = "Lviv";
        final String region = "Lviv";
        final String street = "Bandery";
        List<Reader> listReaders = readerService.findByAddress(city, region, street);
        assertEquals(3, listReaders.size());
    }

    @Test
    public void testFindByAddress4() throws Exception {
        final String city = "Lviv";
        final String region = "Lviv";
        final String street = "Bandery";
        final int buildingNumber = 5;
        List<Reader> listReaders = readerService.findByAddress(city, region, street, buildingNumber);
        assertEquals(2, listReaders.size());
    }

    @Test
    public void testFindByAddress5() throws Exception {
        final String city = "Lviv";
        final String region = "Lviv";
        final String street = "Bandery";
        final int buildingNumber = 5;
        final int apartmentNumber = 1;
        final int apartmentNumberFalse = 5;
        List<Reader> listReaders = readerService.findByAddress(city, region, street, buildingNumber,
                apartmentNumber);
        assertEquals(2, listReaders.size());
        listReaders = readerService.findByAddress(city, region, street, buildingNumber,
                apartmentNumberFalse);
        assertEquals(0, listReaders.size());
    }
}