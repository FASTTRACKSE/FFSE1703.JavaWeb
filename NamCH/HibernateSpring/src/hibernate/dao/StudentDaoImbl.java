package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.entity.Student;

@Repository
public class StudentDaoImbl implements StudentDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addStudent(Student std) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(std);
	}

	@Override
	public void updateStudent(Student std) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(std);
	}

	@Override
	public List<Student> listStudent(int start,int end) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> personsList = session.createQuery("from Student").setFirstResult(start).setMaxResults(end).list();		
		return personsList;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		Student std = (Student) session.load(Student.class, new Integer(id));	
		System.out.println(std.getImage());
		return std;
	}

	@Override
	public void removeStudent(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Student std = (Student) session.load(Student.class, new Integer(id));
		if(null != std){
			session.delete(std);
		}
	}

	@Override
	public Long countStudent() {
		Session session = this.sessionFactory.getCurrentSession();
		Long count = session.createQuery("select count(*) from  Student",Long.class).getSingleResult();
		return count;
	}

}
