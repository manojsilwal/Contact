package edu.contact.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import edu.contact.post.domain.Post;
import edu.contact.user.domain.User;
@Repository
public class PostDAO {
	@Autowired
	SessionFactory  sessionFactory;
	@Transactional
	public void save(Post post){
		sessionFactory.getCurrentSession().persist(post);
	}
	@Transactional
	public void delete(Post post){
		sessionFactory.getCurrentSession().delete(post);
	}
	@Transactional
	public Post getById(Long id){
		return (Post)sessionFactory.getCurrentSession().get(Post.class, id);
	}
	public List<Post> getAll(User user){
		Query query = (Query) sessionFactory.getCurrentSession().createQuery("select distinct post From Post where receiver=creator");
		List<Post> post = ((org.hibernate.Query) query).list();
		System.out.println("========="+post);
		
		return post;
	}
}
