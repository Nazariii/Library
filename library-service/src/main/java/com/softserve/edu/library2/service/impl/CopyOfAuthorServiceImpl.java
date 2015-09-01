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
import com.softserve.edu.library2.repository.AuthorRepository;
import com.softserve.edu.library2.service.AuthorService;

/**
 * @author Назік
 *
 */
@Service("authorJPAService")
public class CopyOfAuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository repository;
	
	@Autowired
	AuthorDAO authorDAO; 

	@Override
	@Transactional("JPAtx")
	public Author findByName(String firstName, String lastName) {
		return repository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	@Transactional("JPAtx")
	public Author findByBook(String name) {
		return repository.findByBookName(name);
	}

	@Override
	@Transactional("JPAtx")
	public List<Author> findSubauthorByBook(String name) {
		return repository.findSubauthorByBook(name);
	}

	@Override
	@Transactional("JPAtx")
	public Author findById(Integer id) {
		return repository.findByauthorId(id);
	}

	@Override
	@Transactional("JPAtx")
	public void save(Author author) {
		repository.save(author);
	}

	@Override
	@Transactional("hibernateTX")
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
	@Transactional("hibernateTX")
	public List<Author> findAll() {
		return authorDAO.findAll(Author.class);
	}

	@Override
	@Transactional("hibernateTX")
	public void deleteById(Integer id) {
		authorDAO.deleteById(id);
	}

}
