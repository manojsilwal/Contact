package edu.contact.service;

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
}
