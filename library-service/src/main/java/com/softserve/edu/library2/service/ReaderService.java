package com.softserve.edu.library2.service;

import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Reader;

import java.util.Date;
import java.util.List;

/**
 * Created by Dmytro on 8/25/2015.
 */
public interface ReaderService {

    public List<Reader> findByName(String firstName, String lastName);

    public List<Reader> findByAddress(Address address);

    public Reader findByTelephone(String telephone);

    public List<Reader> findByBirthDate(Date birthDate);

    public List<Reader> findByBook(String name);
}
