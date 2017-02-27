package edu.contact.service;

import java.util.List;

import edu.contact.post.domain.Post;
import edu.contact.user.domain.User;

public interface PostService {
	public Post findById(long id);
	public void save(Post post);
	public List<Post> findAll();
	public void delete(Post post);
	public void update(Post post);
}
