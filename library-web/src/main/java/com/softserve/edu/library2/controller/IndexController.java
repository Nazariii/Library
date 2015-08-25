/**
 * 
 */
package com.softserve.edu.library2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Taras
 *
 */
@Controller
@RequestMapping("/welcome")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
    	
        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "hello";

    }
    
}