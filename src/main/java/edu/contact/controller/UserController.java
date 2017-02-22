package edu.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.contact.service.UserService;
import edu.contact.user.domain.User;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("/addUser")
	public String formUser(Model model){
		return("userForm");
	}
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(@RequestBody User user,Model model){
		userService.save(user);
		model.addAttribute("user", user);
		return "redirect:/details";
	}
}
