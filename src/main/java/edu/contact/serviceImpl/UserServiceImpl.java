package edu.contact.serviceImpl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.contact.dao.UserDAO;
import edu.contact.domain.User;
import edu.contact.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;


	@Transactional
	public User getUser(long userId) {
		User user = userDAO.load(userId);
		return user;
	}


	@Transactional
	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userDAO.load(id);
	}


	@Transactional
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
	}

	@Transactional
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Transactional
	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDAO.remove(user);
	}

	@Transactional
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDAO.update(user);
	}
}
