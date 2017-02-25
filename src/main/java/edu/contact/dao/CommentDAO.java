package edu.contact.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.contact.post.domain.Comment;
import edu.contact.post.domain.Post;
import edu.contact.service.PostService;

@Repository
public class CommentDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public void save(Comment comment){
		sessionFactory.getCurrentSession().persist(comment);
		
	}
	@Transactional
	public void update(Comment comment){
		sessionFactory.getCurrentSession().saveOrUpdate(comment);
	} 
	@Transactional
	public void delete(Comment comment){
		sessionFactory.getCurrentSession().delete(comment);
	}
	@Transactional
	public Comment getById(Long id){
		return (Comment)sessionFactory.getCurrentSession().get(Comment.class, id);
	}
	
}
