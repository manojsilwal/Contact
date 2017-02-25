package edu.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.contact.service.UserService;
import edu.contact.serviceImpl.PostServiceImpl;
import edu.contact.serviceImpl.UserServiceImpl;


@Controller
public class PostController {
	@Autowired
	PostServiceImpl postServiceImpl;
	@Autowired
	UserService userService;
	@RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
	public String getPost(@PathVariable("id") long id, Model model){		
		model.addAttribute("posts", postServiceImpl.findAll(userService.findById(id)));
		return "dashboard";
	}
	
}
