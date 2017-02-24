package edu.contact.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.contact.dao.PostDAO;
import edu.contact.post.domain.Post;
import edu.contact.service.PostService;
import edu.contact.user.domain.User;
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostDAO postDao;
	@Override
	public Post findById(long id) {
		// TODO Auto-generated method stub
		return postDao.getById(id);
	}

	@Override
	public void save(Post post) {
		// TODO Auto-generated method stub
		postDao.save(post);
	}

	@Override
	public List<Post> findAll(User user) {
		// TODO Auto-generated method stub
		return postDao.getAll(user);
	}

	@Override
	public void delete(Post post) {
		// TODO Auto-generated method stub
		postDao.delete(post);
	}

	@Override
	public void update(Post post) {
		// TODO Auto-generated method stub

	}

}
