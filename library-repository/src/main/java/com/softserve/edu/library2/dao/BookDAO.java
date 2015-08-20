package com.softserve.edu.library2.dao;

import com.softserve.edu.library2.dao.entities.Book;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by vova on 20.08.15.
 */
public interface BookDAO extends GenericDAO<Book,Long> {
    public void updateBook(Long book_id, Book book) throws SQLException;
    public Book getBookById(Long book_id) throws SQLException;
    public Collection getAllBooks() throws SQLException;
    public void deleteBook(Book book) throws SQLException;
}
