package edu.contact.service;

import java.util.List;

import edu.contact.message.domain.Message;
import edu.contact.user.domain.User;


public interface MessageService {
	public Message findById(long id);
	public void save(Message message);
	public List<Message> findAll(User user);
	public void delete(Message message);
	public void update(Message message);
}
