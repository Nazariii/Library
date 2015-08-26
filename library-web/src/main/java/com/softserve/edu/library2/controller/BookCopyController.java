package com.softserve.edu.library2.controller;

import com.softserve.edu.library2.dao.entities.BookCopy;
import com.softserve.edu.library2.service.impl.BookCopyServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;

/**
 * Created by vova on 26.08.15.
 */

@Controller
@RequestMapping("/bookcopy")
public class BookCopyController {
    @RequestMapping(method = RequestMethod.GET)
    public String getFirstBookCopy(ModelMap model){
        BookCopyServiceImpl bookCopyService =new BookCopyServiceImpl();
        BookCopy bookCopy = (BookCopy) bookCopyService.findByName("Kobzar");
        model.addAttribute("bookCopy",bookCopy.getBook().getName());
        return "bookcopy";
    }
}
