package edu.contact.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.contact.user.domain.User;

@Repository
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;


	@Transactional
	public User load(long userId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}
	
	@Transactional
	public void remove(User user) {
		sessionFactory.getCurrentSession().delete(user);;
	}

	@Transactional
	public List<User> findAll() {
		/*"select distinct a from Account a " +
			"join fetch a.customer " +
			"join fetch a.entryList"*/
		Query query = sessionFactory.getCurrentSession().createQuery("select distinct user From User user");
		List<User> users = query.list();
		System.out.println("========="+users);
		
		return users;
	}

	@Transactional
	public void save(User user){
		sessionFactory.getCurrentSession().persist(user);
	}
	
	@Transactional
	public void update(User user){
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	} 
	@Transactional
	public void delete(User user){
		sessionFactory.getCurrentSession().delete(user);
	}
	@Transactional
	public User getById(Long id){
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}
	
}
