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
import java.util.ArrayList;
import java.util.Collections;
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


    @RequestMapping(value = {"/currentbookcopy-{isbn}"}, method = RequestMethod.GET)
    public String listBookCopiesById(ModelMap model, @PathVariable(value = "isbn") Long isbn) {

        if (bookService.getBookByISBN(isbn) == null){
            return "404";
        }

        Character yes = 'Y';
        List<BookCopy> bookCopyList = bookCopyService.findByISBN(isbn);
        List<BookCopy> availableBookCopyList = new ArrayList<BookCopy>();
        List<BookCopy> notAvailableBookCopyList = new ArrayList<BookCopy>();
        for (BookCopy bookCopy : bookCopyList){
            if (bookCopy.getIsPresent().equals(yes)){
                 availableBookCopyList.add(bookCopy);
            }else {
                notAvailableBookCopyList.add(bookCopy);
            }
        }
        Book header =  bookCopyList.get(0).getBook();
        System.out.println(header);

        Boolean avaivableListEmpty = availableBookCopyList.equals(Collections.emptyList());
        Boolean notAvaivableListEmpty = notAvailableBookCopyList.equals(Collections.emptyList());

        model.addAttribute("avaivableListEmpty", avaivableListEmpty);
        model.addAttribute("notAvaivableListEmpty", notAvaivableListEmpty);
        model.addAttribute("availableBookCopyList", availableBookCopyList);
        model.addAttribute("notAvailableBookCopyList", notAvailableBookCopyList);
        model.addAttribute("bookcopies", bookCopyList);
        model.addAttribute("header", header);
        return "bookCopy/currentbookcopy";
    }
}