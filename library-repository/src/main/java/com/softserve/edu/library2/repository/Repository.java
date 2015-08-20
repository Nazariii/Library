/**
 * 
 */
package com.softserve.edu.library2.repository;

import com.softserve.edu.library2.dao.BookCopyDAO;
import com.softserve.edu.library2.dao.BookCopyReaderDAO;
import com.softserve.edu.library2.dao.impl.BookCopyDAOImpl;
import com.softserve.edu.library2.dao.impl.BookCopyReaderDAOImpl;
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
<<<<<<< HEAD
	private AuthorDAO autorDAO = null;
	private BookCopyDAO bookCopyDAO = null;
	private BookCopyReaderDAO bookCopyReaderDAO = null;
	private Repository() {
		autorDAO = new AuthorDAOImpl();
		bookCopyDAO = new BookCopyDAOImpl();
		bookCopyReaderDAO = new BookCopyReaderDAOImpl();
=======
	private AuthorDAO authorDAO = null;
	private AddressDAO addressDAO = null;
	private BookDAO bookDAO = null;
	
	private Repository() {
		authorDAO = new AuthorDAOImpl();
		addressDAO = new AddressDAOImpl();
		bookDAO = new BookDAOImpl();
>>>>>>> a880055eb2fb6baca670e1116e8a6f22002ae947
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

	public BookCopyDAO getBookCopyDAO() {
		logger.info("get BookCopy DAO");
		return bookCopyDAO;
	}

	public BookCopyReaderDAO getBookCopyReaderDAO() {
		logger.info("get BookCopyReader DAO");
		return bookCopyReaderDAO;
	}
}
