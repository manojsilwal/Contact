package edu.contact.message.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import edu.contact.user.domain.User;

@Entity
public class Message {
	@Id
	@GeneratedValue
	Long id;
	@OneToOne
	User sender;
	@OneToOne
	User receiver;
	@OneToMany
	List<Scribble> messages;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public List<Scribble> getMessages() {
		return messages;
	}
	public void setMessages(List<Scribble> messages) {
		this.messages = messages;
	}
}
