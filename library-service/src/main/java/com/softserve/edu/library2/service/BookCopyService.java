package com.softserve.edu.library2.service;

import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;

import java.util.Date;
import java.util.List;

/**
 * Created by vova on 25.08.15.
 */

public interface BookCopyService {
    public List<BookCopy> findByName(String name);

    public List<BookCopy> findByBook(Book book);

    public List<BookCopy> findByReturningDate(Date date);

    public List<BookCopy> findByBorrowingDate(Date date);

    public List<BookCopy> findByPrecence(Character isPresent);

    public List<BookCopy> findByISBN(Long isbn);

    public Author findAuthorOfBookCopy (BookCopy bookCopy);

    public List<BookCopy> findAll();

    public void deleteById(Integer id);

    public void save(BookCopy bookCopy);

    public BookCopy findByID(Integer id);
}
