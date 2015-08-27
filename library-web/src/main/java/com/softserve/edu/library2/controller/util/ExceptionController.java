/**
 * 
 */
package com.softserve.edu.library2.controller.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 
 * @author Назік
 *
 */
@ControllerAdvice
public class ExceptionController {
	
	/**
	 * Handle 404 Exception
	 * 
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleError404(HttpServletRequest request, Exception e) {
		ModelAndView modelAndView = new ModelAndView("/404");
		return modelAndView;
	}
}
