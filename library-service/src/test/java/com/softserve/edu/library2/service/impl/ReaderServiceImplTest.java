package com.softserve.edu.library2.service.impl;

import com.softserve.edu.library2.config.AppConfig;
import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.service.ReaderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

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

    }

    @Test
    public void testFindByTelephone() throws Exception {

    }

    @Test
    public void testFindByBirthDate() throws Exception {

    }

    @Test
    public void testFindByBook() throws Exception {

    }
}