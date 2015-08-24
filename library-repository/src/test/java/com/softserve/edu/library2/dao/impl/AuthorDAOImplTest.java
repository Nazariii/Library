package com.softserve.edu.library2.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.dao.util.HibernateUtil;

public class AuthorDAOImplTest {


	@Test
	public void testSave() {
		Author author = new Author();
		author.setFirstName("Ivan");
		author.setLastName("Ivanovych");
		AuthorDAOImpl authorDAO = new AuthorDAOImpl();
		HibernateUtil.beginTransaction();
		authorDAO.save(author);
		HibernateUtil.commitTransaction();
		assertTrue(true);
	}

	@Test
	public void testFindByName() {
		HibernateUtil.beginTransaction();
		AuthorDAOImpl authorDAO = new AuthorDAOImpl();
		Author author = authorDAO.findByName("Ivan", "Ivanovych");
		HibernateUtil.commitTransaction();
		assertEquals("Ivan", author.getFirstName());

	}

	@Test
	public void testFindByBook() {
		HibernateUtil.beginTransaction();
		AuthorDAOImpl authorDAO = new AuthorDAOImpl();
		Author author = authorDAO.findByBook("Kobzar");
		HibernateUtil.commitTransaction();
		assertEquals("Taras", author.getFirstName());

	}
}
