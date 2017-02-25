package edu.contact.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.contact.message.domain.Message;
import edu.contact.user.domain.User;

@Repository
public class MessageDAO {
	@Autowired
	SessionFactory  sessionFactory;
	@Transactional
	public void save(Message message){
		sessionFactory.getCurrentSession().persist(message);
	}
	@Transactional
	public void delete(Message message){
		sessionFactory.getCurrentSession().delete(message);
	}
	@Transactional
	public Message getById(Long id){
		return (Message)sessionFactory.getCurrentSession().get(Message.class, id);
	}
	public List<Message> getAll(User user){
		Query query = (Query) sessionFactory.getCurrentSession().createQuery("select distinct message From Message where receiver=user");
		List<Message> messages = ((org.hibernate.Query) query).list();
		System.out.println("========="+messages);
		
		return messages;
	}
}
