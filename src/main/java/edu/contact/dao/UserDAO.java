package edu.contact.dao;

<<<<<<< HEAD
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
=======
>>>>>>> 7a6e7b62313eed9a3a4ca0a67056efbb4acef98e
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import edu.contact.domain.User;
=======
import edu.contact.user.domain.Student;
import edu.contact.user.domain.User;
>>>>>>> 7a6e7b62313eed9a3a4ca0a67056efbb4acef98e

@Repository
public class UserDAO {
	@Autowired
<<<<<<< HEAD
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
=======
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
>>>>>>> 7a6e7b62313eed9a3a4ca0a67056efbb4acef98e
	}
	
}
