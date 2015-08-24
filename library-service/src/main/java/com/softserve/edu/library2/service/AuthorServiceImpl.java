/**
 * 
 */
package com.softserve.edu.library2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.edu.library2.dao.AuthorDAO;
import com.softserve.edu.library2.dao.entities.Author;

/**
 * @author Назік
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorDAO authorDAO; 
	
	@Override
	@Transactional
	public Author findByName(String firstName, String lastName) {
		return authorDAO.findByName(firstName, lastName);
	}

}
