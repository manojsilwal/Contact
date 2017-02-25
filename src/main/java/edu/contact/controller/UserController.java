package edu.contact.controller;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.contact.service.UserService;
import edu.contact.user.domain.User;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ServletContext servletContext;


	@RequestMapping(value="/users",method=RequestMethod.GET,headers = "Accept=application/json")
	public @ResponseBody List<User> getUsers(){
		try {

			System.out.println("Successfully listed user list with " + userService.findAll().size() + " rows");
			return userService.findAll();

		} catch (Exception e) {
			System.err.println("Error in lising users: " + e.getMessage());
			return null;

		}
	}
	
	@RequestMapping(value="user/{id}",method=RequestMethod.GET,headers = "Accept=application/json")
	public @ResponseBody User getUser(@PathVariable long id){
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

			System.out.println("inside user POST");
			userService.save(user);
			
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

	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public @ResponseBody User add(@Valid @RequestBody User user,Model model){
		userService.save(user);
		model.addAttribute("user", user);
		return user;
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(@RequestBody User user,Model model){
		userService.save(user);
		model.addAttribute("user", user);
		return "redirect:/details";
	}
	
	
	 @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
	    public void echoFile(@RequestBody MultipartHttpServletRequest request,
	            HttpServletResponse response, BindingResult result) throws Exception {
	    
	        MultipartFile imageFile = request.getFile("file");
	        String rootDirectory = servletContext.getRealPath("/");
			String fileName = imageFile.getOriginalFilename();
			String extension = null;
			if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
				extension = fileName.substring(fileName.lastIndexOf(".") + 1);
			if (imageFile != null && !imageFile.isEmpty()) {
				try {
					imageFile.transferTo(
							new File(rootDirectory + "/resources/images/test" + "." + extension));
					System.out.println("filesaved"+imageFile.getName());
				} catch (Exception e) {
					throw new RuntimeException("Image saving faile", e);

				}
			}
	    }
}
