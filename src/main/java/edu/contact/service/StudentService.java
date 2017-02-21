package edu.contact.service;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.contact.dao.StudentDAO;
import edu.contact.user.domain.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDAO studentdao;
//	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	

	@Transactional
	public Student getStudent(long studentid) {
		Student student = studentdao.load(studentid);
		return student;
	}
}
