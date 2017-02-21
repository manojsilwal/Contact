package edu.contact.message.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Scribble {
	@Id
	private Long id;
	String text;
}
