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
	
	@RequestMapping(value= {"/booklist"}, method = RequestMethod.GET)
	public String getBookList(ModelMap model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "book/booklist";
	}
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String addBook(ModelMap model) {
		Book book = new Book();
		List<Author> authorList = authorService.findAll();
		int authorId = 0;
		model.addAttribute("book", book);
		model.addAttribute("authorList", authorList);
		model.addAttribute("authorId", authorId);
		return "book/addbook";
	}
	
	@RequestMapping(value = {"/books-author-{id}"}, method = RequestMethod.GET)
	public String getBooksByAuthor(@Valid int id, ModelMap model) {
		List<Book> books = bookService.getBooksByAuthorId(id);
		model.addAttribute("books", books);
		return "book/author_books";
	}
	
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String saveBook(@Valid Book book, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "book/booklist";
		}
		
		bookService.save(book);

		return "redirect:booklist";
	}
}
