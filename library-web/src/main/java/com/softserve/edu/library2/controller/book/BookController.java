package com.softserve.edu.library2.controller.book;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.dao.entities.Book;
import com.softserve.edu.library2.service.AuthorService;
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
	
	@Autowired
	AuthorService authorService;
	
	@RequestMapping(value= {"/"}, method = RequestMethod.GET)
	public String getBookList(ModelMap model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "book/booklist";
	}
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String addBook(ModelMap model) {
		Book book = new Book();
		List<Author> authorList = authorService.findAll();
		
		model.addAttribute("book", book);
		model.addAttribute("authorList", authorList);
		return "book/addbook";
	}
	
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String saveUser(@Valid Book book, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "newauthor";
		}
		//TODO create method save in BookService
		//bookService.save(book);

		model.addAttribute("success", "Book " + book.getName() + " was registered successfully");
		return "redirect:/books/";
	}
}
