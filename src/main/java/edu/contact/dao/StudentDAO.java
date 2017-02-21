package edu.contact.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.contact.user.domain.Student;

@Repository
public class StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Transactional
	public Student load(long studentid) {
		Student student = new Student(1, "Frank", "Brown");
		sessionFactory.getCurrentSession().persist(student);
		return (Student) sessionFactory.getCurrentSession().get(Student.class, studentid);
	}
}
