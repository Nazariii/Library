/**
 * 
 */
package com.softserve.edu.library2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.softserve.edu.library2.dao.entities.Author;
import com.softserve.edu.library2.service.AuthorService;

/**
 * @author Назік
 *
 */
@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;  
	
	/*@Autowired
	MessageSource messageSource;*/
	
	@RequestMapping(value= {"/","/list"},method = RequestMethod.GET)
	public String listAuthor(ModelMap model) {
		List<Author> authors = authorService.findAll();
		model.addAttribute("authors",authors);
		return "authorlist";
	}
	
	@RequestMapping(value= {"/aaa"},method = RequestMethod.GET)
	public String aaa(ModelMap model) {
		return "aaa";
	}
	
	@RequestMapping(value= {"/newauthor"},method = RequestMethod.GET)
	public String newAuthor(ModelMap model) {
		Author author = new Author();
		model.addAttribute("author",author);
		model.addAttribute("edit", false);
		return "registration";
	}
}
