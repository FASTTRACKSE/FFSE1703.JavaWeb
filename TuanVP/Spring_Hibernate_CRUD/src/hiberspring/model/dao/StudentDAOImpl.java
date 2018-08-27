package hiberspring.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hiberspring.model.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudent(int start, int limit) {
		Session session = sessionFactory.getCurrentSession();
		List<Student> students = session.createQuery("from Student").setFirstResult(start).setMaxResults(limit).list();
		return students;
	}

	@Override
	public boolean checkStudent(String maSV) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, maSV);
		if (student != null) {
			return true;
		}
		return false;
	}

	@Override
	public void addStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(student);
	}

	@Override
	public Student getStudentById(String maSV) {
		return sessionFactory.getCurrentSession().get(Student.class, maSV);
	}

	@Override
	public void updateStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);;
	}

	@Override
	public void deleteStudent(String maSV) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.load(Student.class, maSV);
		if (student != null) {
			session.delete(student);
		}
	}

	@Override
	public int countStudents() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from Student").list().size();
		return rowCount;
	}

}
