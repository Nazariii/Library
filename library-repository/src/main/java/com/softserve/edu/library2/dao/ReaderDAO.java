package com.softserve.edu.library2.dao;

import com.softserve.edu.library2.dao.entities.Reader;

import java.util.List;

/**
 * @author Dmytro Brylyuk
 */
public interface ReaderDAO extends GenericDAO<Reader, Integer> {
    public List<Reader> findByName(String firstName, String lastName);
}