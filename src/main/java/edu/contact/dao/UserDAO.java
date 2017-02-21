package edu.contact.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.contact.user.domain.Student;
import edu.contact.user.domain.User;

@Repository
public class UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public void add(User user){
		sessionFactory.getCurrentSession().persist(user);
	} 
	@Transactional
	public void delete(Long id){
		Student student=(Student)sessionFactory.getCurrentSession().get(User.class, id);
		sessionFactory.getCurrentSession().delete(student);
	}
	@Transactional
	public User getById(Long id){
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}
	
}
