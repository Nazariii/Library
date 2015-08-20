/**
 * 
 */
package com.softserve.edu.library2.repository;

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

	private Repository() {
		autorDAO = new AuthorDAOImpl();
	}

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

}
