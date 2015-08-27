package com.softserve.edu.library2.controller.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.service.BookService;

/**
 * 
 * @author Taras
 *
 */
@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value= {"/"},method = RequestMethod.GET)
	public String getBookList(ModelMap model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "book/booklist";
	}
	
}
