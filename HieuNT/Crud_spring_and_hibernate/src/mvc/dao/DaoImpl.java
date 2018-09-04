package mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mvc.entity.Student;

@Repository
public class DaoImpl implements SinhVienDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Student> getAll() {
//		Session session = this.sessionFactory.getCurrentSession();
//		List<Student> list= session.createQuery("from Student").list();
//		return list;
//	}

	@Override
	public void addSV(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void deleteSinhVien(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student p = (Student) session.load(Student.class, new Integer(id));
		session.delete(p);

	}

	@Override
	public Student getSinhVienByID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Student.class, id);
	}

	@Override
	public void updateSV(Student p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);

		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll(Integer offset, Integer maxResult) {
		Session session = sessionFactory.getCurrentSession();
		List<Student> students = session.createQuery("from Student").setFirstResult(offset).setMaxResults(maxResult).list();
		return students;
	}

	@Override
	public int count() {

		Session session = sessionFactory.getCurrentSession();
		int rowCount = session.createQuery("from Student").list().size();
		return rowCount;
		
	}



}
