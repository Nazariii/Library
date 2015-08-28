package com.softserve.edu.library2.controller.book;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = { "/booklist" }, method = RequestMethod.GET)
	public String getBookList(ModelMap model) {
		List<Book> books = bookService.getAllBooks();

		model.addAttribute("books", books);

		return "book/booklist";
	}

	@RequestMapping(value = { "/add-{authorId}" }, method = RequestMethod.GET)
	public String addBook(@PathVariable Integer authorId, ModelMap model) {
		Book book = new Book();
		Author author = authorService.findById(authorId);
		book.setAuthor(author);

		model.addAttribute("book", book);
		model.addAttribute("authorId", authorId);

		return "book/addbook";
	}

	@RequestMapping(value = { "/add-{authorId}" }, method = RequestMethod.POST)
	public String saveBook(@Valid Book book, @PathVariable Integer authorId, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "book/booklist";
		}
		Author author = authorService.findById(authorId);
		book.setAuthor(author);
		bookService.save(book);

		return "redirect:books-author-" + authorId;
	}

	@RequestMapping(value = { "/books-author-{id}" }, method = RequestMethod.GET)
	public String getBooksByAuthor(@PathVariable Integer id, ModelMap model) {
		List<Book> books = bookService.getBooksByAuthorId(id);
		Author author = authorService.findById(id);

		model.addAttribute("books", books);
		model.addAttribute("author", author);

		return "book/author_books";
	}

	@RequestMapping(value = { "/delete-book-{bookIsbn}" }, method = RequestMethod.GET)
	public String deleteBook(@PathVariable Long bookIsbn, ModelMap model) {
		bookService.deleteByIsbn(bookIsbn);
		return "redirect:booklist";
	}

	@RequestMapping(value = { "/edit-book-{authorId}-{bookIsbn}" }, method = RequestMethod.GET)
	public String editBook(@PathVariable Integer authorId, @PathVariable Long bookIsbn, ModelMap model) {
		Book book = bookService.getBookByISBN(bookIsbn);

		model.addAttribute("book", book);

		return "book/editbook";
	}

	@RequestMapping(value = { "/edit-book-{authorId}-{bookIsbn}" }, method = RequestMethod.POST)
	public String editBook(@Valid Book book, @PathVariable Integer authorId, @PathVariable Long bookIsbn,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "redirect:/edit-book-" + authorId + "-" + bookIsbn;
		}
		Author author = authorService.findById(authorId);
		book.setAuthor(author);
		book.setIsbn(bookIsbn);
		bookService.update(book);

		return "redirect:booklist";
	}
}
