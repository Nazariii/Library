/**
 * 
 */
package com.softserve.edu.library2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Taras
 *
 */
@Controller
public class BookController {
	 @RequestMapping("/hello")
	 public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name,
		 	Model model) {  
	   model.addAttribute("name", name);
	   //returns the view name
	   return "helloworld";
	 
	 }
}
