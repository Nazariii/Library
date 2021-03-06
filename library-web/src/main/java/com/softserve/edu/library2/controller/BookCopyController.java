package com.softserve.edu.library2.controller;

import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.service.BookCopyService;
import com.softserve.edu.library2.service.BookService;
import com.softserve.edu.library2.service.impl.BookCopyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by vova on 26.08.15.
 */

@Controller
@RequestMapping("/bookcopies")
public class BookCopyController {

    @Autowired
    BookCopyService bookCopyService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listBookCopies(ModelMap model) {
        List<BookCopy> bookCopyList =(List<BookCopy>)  bookCopyService.findAll();
        model.addAttribute("bookcopies", bookCopyList);
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        System.out.println(books);
        return "bookCopy/bookcopy";
    }


    @RequestMapping(value = {"/isbn"}, method = RequestMethod.GET)
    public String listBookCopiesById(ModelMap model, @PathVariable(value = "isbn") Long isbn) {
        List<BookCopy> bookCopyList = bookCopyService.findByISBN(isbn);
        model.addAttribute("bookcopies", bookCopyList);
        return "bookcopy";
    }
}