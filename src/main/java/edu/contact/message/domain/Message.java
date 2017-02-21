package edu.contact.message.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import edu.contact.user.domain.User;

@Entity
public class Message {
	@Id
	Long id;
	@OneToOne
	User sender;
	@OneToOne
	User receiver;
	@OneToMany
	List<Scribble> messages;
}
