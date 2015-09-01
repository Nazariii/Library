/**
 * 
 */
package com.softserve.edu.library2.dao.factory;

import com.softserve.edu.library2.dao.*;
import com.softserve.edu.library2.dao.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Назік
 *
 */
public class Repository {
	private static Logger logger = LogManager.getLogger();

	private static Repository instance = null;

	private AuthorDAO authorDAO = null;
	private BookCopyDAO bookCopyDAO = null;
	private BookCopyReaderDAO bookCopyReaderDAO = null;
	private AddressDAO addressDAO = null;
	private BookDAO bookDAO = null;
	private ReaderDAO readerDAO = null;
	
	private Repository() {
		authorDAO = new AuthorDAOImpl();
		bookCopyDAO = new BookCopyDAOImpl();
		bookCopyReaderDAO = new BookCopyReaderDAOImpl();
		addressDAO = new AddressDAOImpl();
		bookDAO = new BookDAOImpl();
		readerDAO = new ReaderDAOImpl();
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

	public ReaderDAO getReaderDAO() {
		logger.info("get Reader DAO");
		return readerDAO;
	}
}
