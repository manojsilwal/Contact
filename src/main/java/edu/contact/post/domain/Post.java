package edu.contact.post.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.contact.user.domain.User;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	@ManyToOne
	@JoinTable(name="User_Post")
	private User user;
	@OneToMany
	private List<Comment> comments;
	
	@Temporal(TemporalType.DATE)
	private Date date;

	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() { 
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
