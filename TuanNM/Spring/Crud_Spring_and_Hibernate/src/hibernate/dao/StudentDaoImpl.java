package hibernate.dao;

import java.util.List;
//import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	// private static final Logger logger = (java.util.logging.Logger)
	// LoggerFactory.getLogger(StudentDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addStudent(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		// logger.info("Person saved successfully, Person Details="+p);

	}

	@Override
	public void updateStudent(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		// logger.info("Person saved successfully, Person Details="+p);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudent(int start, int maxRows) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> ListStudent = (List<Student>) session.createQuery("FROM Student").setFirstResult(start)
				.setMaxResults(maxRows).list();
		
		return ListStudent;
	}

	@Override
	public Student getStudentById(int id) {
		Session session = this.sessionFactory.openSession();
		Student p = (Student) session.load(Student.class, new Integer(id));
		// logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeStudent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student p = (Student) session.load(Student.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		// logger.info("Person deleted successfully, person details="+p);

	}

	@Override
	public Long countStudent() {
		return (Long) sessionFactory.getCurrentSession().createCriteria(Student.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

}
