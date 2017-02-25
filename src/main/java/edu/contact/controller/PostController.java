package edu.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.contact.post.domain.Post;
import edu.contact.service.PostService;
import edu.contact.service.UserService;
import edu.contact.serviceImpl.PostServiceImpl;
import edu.contact.serviceImpl.UserServiceImpl;


@Controller
public class PostController {
	@Autowired
	PostService postService;
	@Autowired
	UserService userService;
	@RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
	public String getPost(@PathVariable("id") long id, Model model){		
		model.addAttribute("posts", postService.findAll(userService.findById(id)));
		return "dashboard";
	}
	@RequestMapping(value="/post/{id}", method=RequestMethod.POST)
	public @ResponseBody Post addPost(@RequestBody Post post, @PathVariable("id") long id){
		
		postService.save(post);
		return post;
	}
	@RequestMapping(value="/deletePost", method=RequestMethod.DELETE)
	public void deletePost(Post post){
		postService.delete(post);
	}
		
}
