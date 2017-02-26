package edu.contact.service;

import java.util.List;

import edu.contact.post.domain.Comment;
import edu.contact.post.domain.Post;

public interface CommentService {
	public Comment findById(long id);
	public void save(Comment comment);
	public void delete(Comment comment);
	public void update(Comment comment);
}
