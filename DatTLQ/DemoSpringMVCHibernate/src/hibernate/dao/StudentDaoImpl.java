package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.entity.Student;
@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addStudent(Student sv) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sv);
	}

	@Override
	public void updateStudent(Student sv) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sv);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentList = session.createQuery("from Student").list();
		
		return studentList;
	
	}

	@Override
	public Student getStudentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		return session.get(Student.class, id);
	}

	@Override
	public void removeStudent(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student sv = (Student) session.load(Student.class, new Integer(id));
		if(null != sv){
			session.delete(sv);
		}
		
	}
	@Override
	public List<Student> listStudent(int start, int limit) {
		Session session = sessionFactory.getCurrentSession();
		List<Student> students = session.createQuery("from Student").setFirstResult(start).setMaxResults(limit).list();
		return students;
	}
	
	
	public int countStudents() {
		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from Student").list().size();
		return rowCount;
	}
	

}
