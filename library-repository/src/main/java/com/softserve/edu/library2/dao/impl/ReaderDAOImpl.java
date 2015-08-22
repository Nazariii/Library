package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.ReaderDAO;
import com.softserve.edu.library2.dao.entities.Reader;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.hibernate.Query;

/**
 * @author Dmytro Brylyuk
 */
public class ReaderDAOImpl extends AbstractDAO<Reader, Integer> implements ReaderDAO {
    /**
     * Method finds author by first name and last name
     */
    public Reader findByName(String firstName, String lastName, String middleName) {
        String sql = "FROM Reader WHERE firstName = :firstName AND lastName = :lastName";
        Query query = HibernateUtil.getSession().createQuery(sql).setString("firstName", firstName)
                .setString("lastName", lastName).setString("middleName", middleName);
        Reader reader = findOne(query);
        return reader;
    }
}
