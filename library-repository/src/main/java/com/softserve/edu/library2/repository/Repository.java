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

import com.softserve.edu.library2.dao.AuthorDAO;
import com.softserve.edu.library2.dao.impl.AuthorDAOImpl;

/**
 * @author Назік
 *
 */
public class Repository {
	private static Logger logger = LogManager.getLogger();

	private static Repository instance = null;
	private AuthorDAO autorDAO = null;
	private BookCopyDAO bookCopyDAO = null;
	private BookCopyReaderDAO bookCopyReaderDAO = null;
	private Repository() {
		autorDAO = new AuthorDAOImpl();
		bookCopyDAO = new BookCopyDAOImpl();
		bookCopyReaderDAO = new BookCopyReaderDAOImpl();
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
	public AuthorDAO getAutorDAO() {
		logger.info("get Author DAO");
		return autorDAO;
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
