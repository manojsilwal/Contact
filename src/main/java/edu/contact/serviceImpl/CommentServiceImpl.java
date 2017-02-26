package edu.contact.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.contact.dao.CommentDAO;
import edu.contact.post.domain.Comment;
import edu.contact.post.domain.Post;
import edu.contact.service.CommentService;

public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDAO commentDao;
	@Override
	public Comment findById(long id) {
		// TODO Auto-generated method stub
		return commentDao.getById(id);
	}

	@Override
	public void save(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.save(comment);
	}


	@Override
	public void delete(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.delete(comment);
	}

	@Override
	public void update(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.update(comment);
	}


}
