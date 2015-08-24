/**
 * 
 */
package com.softserve.edu.library2.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.softserve.edu.library2.config.AppConfig;
import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.dao.impl.AuthorDAOImpl;
import com.softserve.edu.library2.dao.util.HibernateUtil;
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
		authorService = (AuthorService) context.getBean("authorServiceImpl");
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

}
