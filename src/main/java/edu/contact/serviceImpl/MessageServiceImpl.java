package edu.contact.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.contact.dao.MessageDAO;
import edu.contact.message.domain.Message;
import edu.contact.service.MessageService;
import edu.contact.user.domain.User;
@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageDAO messageDao;
	@Override
	public Message findById(long id) {
		// TODO Auto-generated method stub
		
		return messageDao.getById(id);
	}
	@Override
	public void save(Message message) {
		// TODO Auto-generated method stub
		messageDao.save(message);		
	}
	@Override
	public List<Message> findAll(User user) {
		// TODO Auto-generated method stub
		return messageDao.getAll(user);
	}
	@Override
	public void delete(Message message) {
		// TODO Auto-generated method stub
		messageDao.delete(message);
	}
	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		
	}
}
