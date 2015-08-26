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
@Service("authorService")
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

	@Override
	@Transactional
	public Author findById(Integer id) {
		return authorDAO.findByID(Author.class, id);
	}

	@Override
	@Transactional
	public void save(Author author) {
		authorDAO.save(author);
	}

	@Override
	@Transactional
	public void update(Author author) {
		Author entity = authorDAO.findByID(Author.class, author.getAuthorId());
		if (entity != null) {
			entity.setAuthorId(author.getAuthorId());
			entity.setBook(author.getBook());
			entity.setBookauthors(author.getBookauthors());
			entity.setFirstName(author.getFirstName());
			entity.setLastName(author.getLastName());
		}
	}

	@Override
	@Transactional
	public List<Author> findAll() {
		return authorDAO.findAll(Author.class);
	}

}
