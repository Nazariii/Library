/**
 * 
 */
package com.softserve.edu.library2.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.softserve.edu.library2.config.AppConfig;
import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.service.AuthorService;

/**
 * @author Назік
 *
 */
public class AuthorServiceImplTest {

	AbstractApplicationContext context;
	AuthorService authorService;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		authorService = (AuthorService) context.getBean("authorService");
	}

	/**
	 * Test method for
	 * {@link com.softserve.edu.library2.service.impl.impl.AuthorServiceImpl#findByName(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testFindByName() {
		Author author = authorService.findByName("Ivan", "Franko");
		assertEquals("Ivan", author.getFirstName());
	}

	@Test
	public void testFindByBook() {
		Author author = authorService.findByBook("Kobzar");
		assertEquals("Taras", author.getFirstName());
	}

	@Test
	public void testFindSubauthorByBook() {
		List<Author> author = authorService.findSubauthorByBook("Sql vs Java");
		assertEquals("Dmytro", author.get(0).getFirstName());

	}

	@Test
	public void testFindById() {
		Author author = authorService.findById(2);
		assertEquals("Dmytro", author.getFirstName());
	}

	@Test
	public void testUpdate() {
		Author author = authorService.findById(8);
		author.setFirstName("Dmytro111");
		authorService.update(author);
		assertEquals("Dmytro111", author.getFirstName());
	}
}
