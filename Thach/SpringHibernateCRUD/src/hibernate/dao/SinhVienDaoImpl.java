package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.entity.SinhVien;

@Repository
public class SinhVienDaoImpl implements SinhVienDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> listSinhVien(int start, int limit) {
		Session session = this.sessionFactory.getCurrentSession();
		List<SinhVien> listSinhVien = session.createQuery("from SinhVien").setFirstResult(start).setMaxResults(limit).list();
		return listSinhVien;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SinhVien sv = (SinhVien) session.load(SinhVien.class, new Integer(id));
		session.delete(sv);
	}

	@Override
	public SinhVien getEdit(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(SinhVien.class, (id));
	}

	@Override
	public void update(SinhVien sv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sv);
	}

	@Override
	public void insert(SinhVien sv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sv);

	}

	@Override
	public int checkExistMaSv(String maSv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public long totalRecord() {
		Session session = this.sessionFactory.getCurrentSession();
		Long count =(Long) session.createCriteria(SinhVien.class).setProjection(Projections.rowCount()).uniqueResult();
		return count;
	}
}
