package spring.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.model.entity.SinhVien;

@Repository
public class SinhVienDaoIPM implements SinhVienDao {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(SinhVien sinhvien) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sinhvien);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SinhVien> listStudent() {
		Session session = sessionFactory.getCurrentSession();
		List<SinhVien> list = session.createQuery("from SinhVien").getResultList();

		return list;
	}

	@Override
	public SinhVien findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SinhVien u = (SinhVien) session.get(SinhVien.class, id);
		return u;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findById(id));
	}

	@Override
	public void update(SinhVien sinhvien) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sinhvien);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from SinhVien");
		q.setFirstResult(startPosition);
		q.setMaxResults(maxResult);
		
		return q.list();		
	}

}
