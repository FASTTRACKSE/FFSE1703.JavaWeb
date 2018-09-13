package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudent(int start, int maxRows) {

		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentList = (List<Student>) session.createQuery("FROM Student").setFirstResult(start).setMaxResults(maxRows).list();
		return studentList;
	}

	@Override
	public void addStudent(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void updateStudent(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	}

	@Override
	public Student getStudentById(int id) {
		Session session = this.sessionFactory.openSession();
		Student p = (Student) session.load(Student.class, new Integer(id));
		return p;
	}

	@Override
	public void removeStudent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student p = (Student) session.load(Student.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}

	@Override
	public int total() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Student").list().size();
	}
}
