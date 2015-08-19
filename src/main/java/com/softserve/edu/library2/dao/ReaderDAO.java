package com.softserve.edu.library2.dao;

import com.softserve.edu.library2.dao.entities.Reader;

/**
 * @author Dmytro Brylyuk
 */
public interface ReaderDAO extends GenericDAO<Reader, Integer> {
    public Reader findByName(String firstName, String lastName, String middleName);
}