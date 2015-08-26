package com.softserve.edu.library2.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.dao.util.HibernateUtil;

public class AuthorDAOImplTest {

	@Ignore
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

	@Ignore
	@Test
	public void testFindByName() {
		HibernateUtil.beginTransaction();
		AuthorDAOImpl authorDAO = new AuthorDAOImpl();
		Author author = authorDAO.findByName("Ivan", "Ivanovych");
		HibernateUtil.commitTransaction();
		assertEquals("Ivan", author.getFirstName());

	}

	@Ignore
	@Test
	public void testFindByBook() {
		HibernateUtil.beginTransaction();
		AuthorDAOImpl authorDAO = new AuthorDAOImpl();
		Author author = authorDAO.findByBook("Kobzar");
		HibernateUtil.commitTransaction();
		assertEquals("Taras", author.getFirstName());
	}

	@Ignore
	@Test
	public void testFindSubauthorByBook() {
		HibernateUtil.beginTransaction();
		AuthorDAOImpl authorDAO = new AuthorDAOImpl();
		List<Author> author = authorDAO.findSubauthorByBook("Sql vs Java");
		HibernateUtil.commitTransaction();
		assertEquals("Dmytro", author.get(0).getFirstName());

	}
}
