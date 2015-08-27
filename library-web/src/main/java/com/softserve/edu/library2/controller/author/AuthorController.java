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

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listAuthor(ModelMap model) {
		List<Author> authors = authorService.findAll();
		model.addAttribute("authors", authors);
		return "author/authorlist";
	}


	@RequestMapping(value = { "/addauthor" }, method = RequestMethod.GET)
	public String newAuthor(ModelMap model) {
		Author author = new Author();
		model.addAttribute("author", author);
		model.addAttribute("edit", false);
		return "author/newauthor";
	}

	@RequestMapping(value = { "/addauthor" }, method = RequestMethod.POST)
	public String saveUser(@Valid Author author, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "author/newauthor";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be
		 * implementing custom @Unique annotation and applying it on field [sso]
		 * of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you
		 * can fill custom errors outside the
		 * 
		 * validation framework as well while still using internationalized
		 * messages.
		 */
		/*
		 * if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
		 * FieldError ssoError = new FieldError("user", "ssoId",
		 * messageSource.getMessage("non.unique.ssoId", new String[] {
		 * user.getSsoId() }, Locale.getDefault())); result.addError(ssoError);
		 * return "registration"; }
		 */

		authorService.save(author);

		model.addAttribute("success", "User " + author.getFirstName() + " " + author.getLastName()
				+ " registered successfully");
		// return "success";
		return "redirect:/authors/list";
	}
}
