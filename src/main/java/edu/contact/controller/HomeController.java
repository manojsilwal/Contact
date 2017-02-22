package edu.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.contact.service.StudentService;

@Controller		
public class HomeController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String homePage(){
		System.out.println(studentService.getStudent(1));
		return "register";
	}
}
