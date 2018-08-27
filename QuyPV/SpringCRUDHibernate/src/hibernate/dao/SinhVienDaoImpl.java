package hibernate.dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.entity.SinhVien;

@Repository
public class SinhVienDaoImpl implements SinhVienDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> sinhVienList(int start, int end) {
		Session session= this.sessionFactory.getCurrentSession();
		List<SinhVien> sinhVienList = session.createQuery("from SinhVien").setFirstResult(start).setMaxResults(end).list();
		
		return sinhVienList;
	}
	
	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SinhVien sv = session.load(SinhVien.class, id);
		session.delete(sv);
		
	}

	@Override
	public SinhVien getEdit(int id) {
		Session sesion = this.sessionFactory.getCurrentSession();
		
		return sesion.get(SinhVien.class, id);
	}

	@Override
	public void update(SinhVien sv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(SinhVien sv) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(sv);	
	}
	
	@Override
	public String checkExistMaSv(String maSv) {
		Session session= this.sessionFactory.getCurrentSession();
		String hql = "FROM SinhVien sv WHERE sv.masv = " + maSv;
		if(session.createQuery(hql) != null) {
			return "true";
		} else {
			return "false";
		}
	
	}

	@SuppressWarnings("deprecation")
	@Override
	public long totalRecord() {
		Session session= this.sessionFactory.getCurrentSession();
		
		return (long) session.createCriteria(SinhVien.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
	}

}
