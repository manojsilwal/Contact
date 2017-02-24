package edu.contact.post.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.contact.user.domain.User;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	@OneToOne
	User creator;
	@OneToOne
	
	@Temporal(TemporalType.DATE)
	private Date date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
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
	public User getUser() {
		return creator;
	}
	public void setUser(User user) {
		this.creator = user;
	}
}
