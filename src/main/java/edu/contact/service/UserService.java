package edu.contact.service;

<<<<<<< HEAD
import java.util.List;

import edu.contact.domain.User;

public interface UserService {
	public User findById(long id);
	public void save(User user);
	public List<User> findAll();
	public void delete(User user);
	public void update(User user);
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.contact.dao.UserDAO;
import edu.contact.user.domain.Student;
import edu.contact.user.domain.User;

@Service
public class UserService {
	@Autowired
	UserDAO userDao;
	@Transactional
	public void save(User user){
		userDao.add(user);
	}
	public void delete(Long id){
		userDao.delete(id);
	}
	public User getById(Long id){
		return userDao.getById(id);
	}
>>>>>>> 7a6e7b62313eed9a3a4ca0a67056efbb4acef98e
}
