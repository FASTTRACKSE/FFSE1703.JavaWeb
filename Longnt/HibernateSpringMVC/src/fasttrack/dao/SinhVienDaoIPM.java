package fasttrack.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrack.entity.Student;


@Repository(value = "sinhVienDaoIPM")
@Transactional(rollbackFor = Exception.class)
public class SinhVienDaoIPM implements SinhVienDao {
	@Autowired
	 SessionFactory sessionFactory;



	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(student);
		
	}

	@SuppressWarnings("unchecked")
	public List<Student> listStudent() {
		Session session = sessionFactory.getCurrentSession();
		List<Student> list = session.createQuery("from Student").getResultList();
	
		return list;
	}

	public Student findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student u = (Student) session.get(Student.class, id);
		return u;
	}

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

	public List<Student> findAllForPaging(int startPosition,int maxResult){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Student");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);
		
		return q.list();		
	}

}
