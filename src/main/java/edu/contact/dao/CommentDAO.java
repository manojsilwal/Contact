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
import edu.contact.user.domain.User;

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
	@Transactional
	public List<Comment> getAll(Post post){
		Query query = (Query) sessionFactory.getCurrentSession().createQuery("select distinct comment From Comment where ");
		List<Comment> comments = ((org.hibernate.Query) query).list();
		System.out.println("========="+post);
		
		return comments;
	}
}
