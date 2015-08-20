package com.softserve.edu.library2.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.util.HibernateUtil;

public class BookDAOImplTest {
	Book book = new Book(1234567891123L, "Hibernate 4 dummies", 3);
	
	@Test
	public void testSave() {
		BookDAOImpl bookDAOImpl = new BookDAOImpl();
		
		HibernateUtil.beginTransaction();
		bookDAOImpl.save(book);
		HibernateUtil.commitTransaction();
		
		assertTrue(true);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDelete() {
		BookDAOImpl bookDAOImpl = new BookDAOImpl();
		
		HibernateUtil.beginTransaction();	
		List<Book> books = (List<Book>) bookDAOImpl.findAll(Book.class);	
		Book lastAddedBook = (Book)books.get(books.size() - 1);
		bookDAOImpl.delete(lastAddedBook);
		HibernateUtil.commitTransaction();
		
		HibernateUtil.beginTransaction();
		boolean result = HibernateUtil.getSession().contains(book);
		HibernateUtil.commitTransaction();
		
		assertFalse(result);
	}
}
