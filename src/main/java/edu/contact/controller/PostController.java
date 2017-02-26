package edu.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.contact.post.domain.Post;
import edu.contact.service.PostService;
import edu.contact.service.UserService;


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
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public @ResponseBody Post addPost(@RequestBody Post post){
		System.out.println("dasdadsd");
		postService.save(post);
		return post;
	}
	@RequestMapping(value="/post/{id}", method=RequestMethod.DELETE)
	public void deletePost(@PathVariable("id") long id){
		postService.delete(postService.findById(id));
	}
		
}
