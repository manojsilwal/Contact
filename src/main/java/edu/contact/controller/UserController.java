package edu.contact.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.contact.POJO.UserBean;
import edu.contact.service.UserService;
import edu.contact.user.domain.User;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ServletContext servletContext;

	 String rootDirectory = "C:/Users/Xitiz/Desktop/Project/Contact/src/main/webapp/resources/images/";
	 public static String imageUrl;

	@RequestMapping(value="/users",method=RequestMethod.GET,headers = "Accept=application/json")
	public @ResponseBody List<UserBean> getUsers(){
		try {
			List<User> users = userService.findAll();
			UserBean userBean = new UserBean();
			List<UserBean> userList = new ArrayList<>();

			System.out.println("Successfully listed user list with " + users.size() + " rows");
			for(User user : users){
				
				userBean.setId(user.getId());
				userBean.setUsername(user.getProfile().getFirstName()+user.getProfile().getLastName());
				userList.add(userBean);
			}
			return userList;

		} catch (Exception e) {
			System.err.println("Error in lising users: " + e.getMessage());
			return null;

		}
	}
	
	@RequestMapping(value="user",method=RequestMethod.GET,headers = "Accept=application/json")
	public @ResponseBody User getUser(@RequestParam("id") long id){
		try {
			System.out.println(userService.findById(id));
			return userService.findById(id);

		} catch (Exception e) {
			System.err.println("Error in lising users: " + e.getMessage());
			return null;

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

	
	@RequestMapping(value="/user",method=RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody User add(@Valid @RequestBody User user,Model model){
		user.setImageUrl(imageUrl);
		userService.save(user);
		model.addAttribute("user", user);
		return user;
	}
	
	
	 @RequestMapping(value = "/saveFile", method = RequestMethod.POST)
	    public void echoFile(@RequestParam("file") MultipartFile multipartFile,Model model) throws Exception {
	    
	        MultipartFile imageFile = multipartFile;
	       
			String fileName = imageFile.getOriginalFilename();
			String extension = null;
			if (imageFile != null && !imageFile.isEmpty()) {
				try {
					imageFile.transferTo(
							new File(rootDirectory+fileName));
					imageUrl = fileName;
					System.out.println("filesaved"+fileName);
				} catch (Exception e) {
					throw new RuntimeException("Image saving faile", e);

				}
			}
	    }
	 
	 @RequestMapping(value="/addUser", method=RequestMethod.GET)
		public String addUser(){
			return "user/form";
		}
	 @RequestMapping(value="/updateUser/{id}",method=RequestMethod.GET)
	 public String addUserFrom(@PathVariable long id, Model model){
		 model.addAttribute("id",id);
		 return "updateUser";
	 }
	 
	 
	 
}
