package edu.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller		
public class HomeController {
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String homePage(){
		return "index";
	}
	@RequestMapping(value="/addUser", method=RequestMethod.GET)
	public String addUser(){
		return "userForm";
	}
	
	@RequestMapping(value="/book", method=RequestMethod.GET)
	public String addForm(){
		return "BookList";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			System.out.println("error");
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
}
