package com.softserve.edu.library2.service.impl;


import com.softserve.edu.library2.dao.BookCopyDAO;
import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.service.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by vova on 25.08.15.
 */
public class BookCopyServiceImpl implements BookCopyService{
    @Autowired
    BookCopyDAO bookCopyDAO;

    @Override
    @Transactional
    public List<BookCopy> findByName(String name) {
        return bookCopyDAO.findByName(name);
    }

    @Override
    @Transactional
    public List<BookCopy> findByBook(Book book) {
        return bookCopyDAO.findByBook(book);
    }

    @Override
    @Transactional
    public List<BookCopy> findByReturningDate(Date date) {
        return bookCopyDAO.findByReturningDate(date);
    }

    @Override
    @Transactional
    public List<BookCopy> findByBorrowingDate(Date date) {
        return bookCopyDAO.findByBorrowingDate(date);
    }

    @Override
    @Transactional
    public List<BookCopy> findByPrecence(Character isPresent) {
        return bookCopyDAO.findByPrecence(isPresent);
    }

    @Override
    @Transactional
    public List<BookCopy> findByISBN(Long isbn) {
        return bookCopyDAO.findByISBN(isbn);
    }

    @Override
    @Transactional
    public Author findAuthorOfBookCopy (BookCopy bookCopy){return bookCopyDAO.findAuthorOfBookCopy(bookCopy);}
}
