package com.fasttrack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasttrack.model.Student;



@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	 SessionFactory sessionFactory;



	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void create(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(student);
		
	}
	
//	public void indexStudents() throws Exception {
//		try {
//			Session session = sessionFactory.getCurrentSession();
//			FullTextSession fullTextSession = Search.getFullTextSession(session);
//			fullTextSession.createIndexer().startAndWait();
//		} catch(Exception e) {
//			throw e;
//		}
//	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Student> listStudent() {
		Session session = sessionFactory.getCurrentSession();
		List<Student> list = session.createQuery("from Student").getResultList();
	
		return list;
	}
	@Override
	public Student findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student u = (Student) session.get(Student.class, id);
		return u;
	}
	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findById(id));
	}
	
	@Override
	public void update(Student student) {
		Session session = this.sessionFactory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.update(student);
		tx.commit();
		session.close();
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Student> findAllForPaging(int startPosition,int maxResult){
		Session session = this.sessionFactory.getCurrentSession();
		Query<Student> q = session.createQuery("from Student");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);
		
		return q.list();		
	}

}