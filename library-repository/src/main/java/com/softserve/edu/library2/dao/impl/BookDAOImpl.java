package com.softserve.edu.library2.dao.impl;

import com.softserve.edu.library2.dao.AbstractDAO;
import com.softserve.edu.library2.dao.BookDAO;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Vova
 *
 */
public class BookDAOImpl extends AbstractDAO<Book, Integer> implements BookDAO {

}
