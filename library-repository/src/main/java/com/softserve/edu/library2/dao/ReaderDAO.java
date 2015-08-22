package com.softserve.edu.library2.dao;

import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Reader;

import java.util.Date;
import java.util.List;

/**
 * @author Dmytro Brylyuk
 */
public interface ReaderDAO extends GenericDAO<Reader, Integer> {
    public List<Reader> findByName(String firstName, String lastName);
    public List<Reader> findByAddress(Address address);
    public Reader findByTelephone(String telephone);
    public List<Reader> findByBirthDate(Date birthDate);
    public List<Reader> findByBook(String name);
}