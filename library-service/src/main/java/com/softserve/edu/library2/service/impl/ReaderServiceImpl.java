package com.softserve.edu.library2.service.impl;

import com.softserve.edu.library2.dao.ReaderDAO;
import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by Dmytro on 8/25/2015.
 */
@Service
public class ReaderServiceImpl implements ReaderService{

    @Autowired
    ReaderDAO readerDAO;

    @Override
    @Transactional
    public List<Reader> findByName(String firstName, String lastName) {
        return readerDAO.findByName(firstName, lastName);
    }

    @Override
    @Transactional
    public List<Reader> findByAddress(Address address) {
        return readerDAO.findByAddress(address);
    }

    @Override
    @Transactional
    public Reader findByTelephone(String telephone) {
        return readerDAO.findByTelephone(telephone);
    }

    @Override
    @Transactional
    public List<Reader> findByBirthDate(Date birthDate) {
        return readerDAO.findByBirthDate(birthDate);
    }

    @Override
    @Transactional
    public List<Reader> findByBook(String name) {
        return readerDAO.findByBook(name);
    }
}
