/**
 * 
 */
package com.softserve.edu.library2.dao.entities;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Назік
 *
 */
public class AuthorTest {

	/**
	 * Test method for {@link com.softserve.edu.library2.dao.entities.Author#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Author firstAuthor = new Author("naz","naz");
		Author secondAuthor = new Author("nassz","nazss");
		firstAuthor.setAuthorId(1);
		secondAuthor.setAuthorId(1);
		assertTrue(firstAuthor.equals(secondAuthor));
	}
	/**
	 * Test method for {@link com.softserve.edu.library2.dao.entities.Author#equals(java.lang.Object)}.
	 */
	@Test
	public void testNotEqualsObject() {
		Author firstAuthor = new Author("naz","naz");
		Author secondAuthor = new Author("naz","naz");
		firstAuthor.setAuthorId(1);
		secondAuthor.setAuthorId(2);
		assertFalse(firstAuthor.equals(secondAuthor));
	}

}
