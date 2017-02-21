package edu.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.contact.domain.User;
import edu.contact.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/users",method=RequestMethod.GET,headers = "Accept=application/json")
	public List<User> getUsers(){
		try {

			System.out.println("Successfully listed user list with " + userService.findAll().size() + " rows");
			return userService.findAll();

		} catch (Exception e) {
			System.err.println("Error in lising users: " + e.getMessage());
			return null;

		}
	}
	
	@RequestMapping(value="user/{id}",method=RequestMethod.GET,headers = "Accept=application/json")
	public User getUser(@PathVariable long id){
		try {
			
			return userService.findById(id);

		} catch (Exception e) {
			System.err.println("Error in lising users: " + e.getMessage());
			return null;

		}
	}

	@RequestMapping(value="/user",method=RequestMethod.POST,headers = "Accept=application/json")
	public void add(@RequestBody User user){
		try {
			userService.save(user);;
			
		} catch (Exception e) {
			System.err.println("Error in lising users: " + e.getMessage());

		}
	}
	
	@RequestMapping(value="/user",method=RequestMethod.PUT,headers = "Accept=application/json")
	public void put(@RequestBody User user){
		try {
			userService.update(user);
			
		} catch (Exception e) {
			System.err.println("Error in lising users: " + e.getMessage());

		}
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE,headers = "Accept=application/json")
	public void delete(@PathVariable long id){
		try {
			userService.delete(userService.findById(id));
			
		} catch (Exception e) {
			System.err.println("Error in lising users: " + e.getMessage());
		}
	}

	@RequestMapping("/addUser")
	public String formUser(Model model){
		return("userForm");
	}
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(Model model, User user){
		userService.save(user);
		model.addAttribute("user", user);
		return "redirect:/details";
	}
}
