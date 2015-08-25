package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.ReaderDAO;
import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Dmytro Brylyuk
 */
@Repository
public class ReaderDAOImpl extends AbstractDAO<Reader, Integer> implements ReaderDAO {

    private static Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     * Method finds reader by first name and last name
     * @param firstName - name of reader
     * @param lastName - lastname of reader
     * @return List of readers
     */
    @Override
    public List<Reader> findByName(String firstName, String lastName) {
        String sql = "FROM Reader WHERE firstName = :firstName AND lastName = :lastName";
        Query query = super.getSession().createQuery(sql).setString("firstName", firstName)
                .setString("lastName", lastName);
        List<Reader> listReaders = Collections.emptyList();
        try {
            listReaders = findMany(query);
        } catch (Exception e) {
            logger.error("Error" ,e);
        }
        return listReaders;
    }

    /**
     * Method to finnd readers by address where they are lives
     * @param address - object of entity Address
     * @return List of readers
     */
    @Override
    public List<Reader> findByAddress(Address address) {
        String sql = "SELECT reader FROM Reader AS reader JOIN reader.address AS address WHERE address LIKE :address";
        Query query = super.getSession().createQuery(sql).setEntity("address", address);
        List<Reader> listReaders = Collections.emptyList();
        try {
            listReaders = findMany(query);
        } catch (Exception e) {
            logger.error("Error" ,e);
        }
        return listReaders;
    }

    /**
     * Method to find readers by telephone number
     * @param telephone - telephone number of reader
     * @return - object reader
     */
    @Override
    public Reader findByTelephone(String telephone) {
        String sql = "FROM Reader WHERE telephone = :telephone";
        Query query = super.getSession().createQuery(sql).setString("telephone", telephone);
        Reader reader = null;
        try {
            reader = findOne(query);
        } catch (Exception e) {
            logger.error("Error", e);
        }
        return reader;
    }

    /**
     * Method to find readers by birth date
     * @param birthDate - birth date of readers/reader
     * @return - List of readers
     */
    @Override
    public List<Reader> findByBirthDate(Date birthDate){
        String sql = "FROM Reader WHERE birthDate = :birthDate";
        Query query = super.getSession().createQuery(sql).setDate("birthDate", birthDate);
        List<Reader> listReaders = Collections.emptyList();
        try {
            listReaders = findMany(query);
        } catch (Exception e) {
            logger.error("Error" , e);
        }
        return listReaders;
    }

    /**
     * Method to find readers by book wich they are takenn
     * @param name - title of book
     * @return - List of readers
     */
    @Override
    public List<Reader> findByBook(String name) {
        String sql = "SELECT reader FROM Reader AS reader JOIN reader.bookCopyReaders AS bCopy WHERE bCopy.book.name = :name";
        Query query = super.getSession().createQuery(sql).setString("name", name);
        List<Reader> listReaders = Collections.emptyList();
        try {
            listReaders = findMany(query);
        } catch (Exception e) {
            logger.error("Error", e);
        }
        return listReaders;
    }
}
