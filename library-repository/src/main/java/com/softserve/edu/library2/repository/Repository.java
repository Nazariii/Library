/**
 * 
 */
package com.softserve.edu.library2.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.softserve.edu.library2.dao.AddressDAO;
import com.softserve.edu.library2.dao.AuthorDAO;
import com.softserve.edu.library2.dao.BookDAO;
import com.softserve.edu.library2.dao.impl.AddressDAOImpl;
import com.softserve.edu.library2.dao.impl.AuthorDAOImpl;
import com.softserve.edu.library2.dao.impl.BookDAOImpl;

/**
 * @author Назік
 *
 */
public class Repository {
	private static Logger logger = LogManager.getLogger();

	private static Repository instance = null;
	private AuthorDAO authorDAO = null;
	private AddressDAO addressDAO = null;
	private BookDAO bookDAO = null;
	
	private Repository() {
		authorDAO = new AuthorDAOImpl();
		addressDAO = new AddressDAOImpl();
		bookDAO = new BookDAOImpl();
	}

	/**
	 * 
	 * @return instance of library repository
	 */
	public Repository getInstance() {
		if (instance == null) {
			synchronized (Repository.class) {
				if (instance == null) {
					instance = new Repository();
				}
			}
		}
		return instance;
	}

	/**
	 * @return the autorDAO
	 */
	public AuthorDAO getAuthorDAO() {
		logger.info("get Author DAO");
		return authorDAO;
	}
	
	/**
	 * @return the addressDAO
	 */
	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	/**
	 * @return the bookDAO
	 */
	public BookDAO getBookDAO() {
		return bookDAO;
	}

}
