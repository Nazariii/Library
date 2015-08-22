package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Dmytro on 8/21/2015.
 */

public class ReaderDAOImplTest {


    @Test
    public void testSave() {
        ReaderDAOImpl readerDAOImpl = new ReaderDAOImpl();
        Reader reader = new Reader("Eric", "Cartman");
        HibernateUtil.beginTransaction();
        readerDAOImpl.save(reader);
        HibernateUtil.commitTransaction();


        assertTrue(true);

    }



}