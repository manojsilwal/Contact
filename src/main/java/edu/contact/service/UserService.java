package edu.contact.service;

import java.util.List;

import edu.contact.domain.User;

public interface UserService {
	public User findById(long id);
	public void save(User user);
	public List<User> findAll();
	public void delete(User user);
	public void update(User user);
}
