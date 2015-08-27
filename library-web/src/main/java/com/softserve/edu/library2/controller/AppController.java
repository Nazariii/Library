/**
 * 
 */
package com.softserve.edu.library2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class AppController {
	
	@Autowired
	AuthorService authorService;  
	
	/*@Autowired
	MessageSource messageSource;*/
	
	@RequestMapping(value= {"/"},method = RequestMethod.GET)
	public String showIndex(ModelMap model) {
		return "index";
	}
	
}
