package com.softserve.edu.library2.dao;

import com.softserve.edu.library2.dao.entities.Address;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.dao.impl.AuthorDAOImpl;
import com.softserve.edu.library2.dao.impl.ReaderDAOImpl;

/**
 * Created by vova on 20.08.15.
 */
public class Factory {

    private static AuthorDAO authorDAO = null;
  /*  private static BookDao bookDAO = null;
    private static BookCopyDAO bookCopyDAO = null;
    private static AddressDAO addressDAO = null;*/
    private static ReaderDAO readerDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }
/*
    public BookDao getBookDAO(){
        if (bookDao == null){
            bookDao = new BookDao();
        }
        return bookDao;
    }

    public AuthorDAO getAuthorDAO(){
        if (authorDAO == null){
            authorDAO = new AuthorDAOImpl();
        }
        return authorDAO;
    }

    public BookCopyDAO getBookCopyDAO(){
        if (BookCopyDAO == null){
            BookCopyDAO = new BookCopyDAOImpl();
        }
        return bookCopyDAO;
    }
    public AddressDAO getAddressDAO(){
        if (addressDAO == null){
            addressDAO = new AddressDAOImpl();
        }
        return addressDAO;
    }
    public BookCopyDAO getBookCopyDAO(){
        if (BookCopyDAO == null){
            BookCopyDAO = new BookCopyDAOImpl();
        }
        return bookCopyDAO;
    }*/
    public ReaderDAO getReaderDAO(){
        if (readerDAO == null){
            readerDAO = new ReaderDAOImpl();
        }
        return readerDAO;
    }
}