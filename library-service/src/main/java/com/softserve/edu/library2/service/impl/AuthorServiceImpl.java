/**
 * 
 */
package com.softserve.edu.library2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.edu.library2.dao.AuthorDAO;
import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.service.AuthorService;

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

	@Override
	@Transactional
	public Author findByBook(String name) {
		return authorDAO.findByBook(name);
	}

	@Override
	@Transactional
	public List<Author> findSubauthorByBook(String name) {
		return authorDAO.findSubauthorByBook(name);
	}

}