/**
 * 
 */
package com.softserve.edu.library2.controller.author;

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
import com.softserve.edu.library2.service.AuthorService;

/**
 * @author Назік
 *
 */
@Controller
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	AuthorService authorService;

	/*
	 * @Autowired MessageSource messageSource;
	 */
	/**
	 * Show list of authors
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listAuthor(ModelMap model) {
		List<Author> authors = authorService.findAll();
		model.addAttribute("authors", authors);
		return "author/authorlist";
	}

	/**
	 * Routes to new author jsp
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/addauthor" }, method = RequestMethod.GET)
	public String newAuthor(ModelMap model) {
		Author author = new Author();
		model.addAttribute("author", author);
		model.addAttribute("edit", false);
		return "author/newauthor";
	}

	/**
	 * Save new author
	 * 
	 * @param author
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/addauthor" }, method = RequestMethod.POST)
	public String saveUser(@Valid Author author, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "author/newauthor";
		}
		authorService.save(author);

		model.addAttribute("success", "User " + author.getFirstName() + " " + author.getLastName()
				+ " registered successfully");
		// return "success";
		return "redirect:/authors/list";
	}

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-author-{id}" }, method = RequestMethod.GET)
	public String editAuthor(@PathVariable String id, ModelMap model) {
		Author author = authorService.findById(Integer.valueOf(id));
		model.addAttribute("author", author);
		model.addAttribute("edit", true);
		return "author/newauthor";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating author in database. It also validates the author input
	 */
	@RequestMapping(value = { "/edit-author-{id}" }, method = RequestMethod.POST)
	public String updateAuthor(@Valid Author author, BindingResult result, ModelMap model, @PathVariable String id) {

		if (result.hasErrors()) {
			return "author/newauthor";
		}
		authorService.update(author);
		model.addAttribute("success", "User " + author.getFirstName() + " " + author.getLastName()
				+ " updated successfully");
		return "redirect:/authors/list";
	}

	/**
	 * This method will delete an user by it's ID value.
	 */
	@RequestMapping(value = { "/delete-author-{id}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String id) {
		authorService.deleteById(Integer.valueOf(id));
		return "redirect:/authors/list";
	}

}
