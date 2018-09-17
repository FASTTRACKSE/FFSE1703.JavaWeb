package fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViec;


// @Repository
// public class QLyNhiemVuDaoImpl implements QLyNhiemVuDao{
// 	@Autowired
// 	private SessionFactory sessionFactory;
	
// 	@SuppressWarnings("unchecked")
// 	@Override
// 	public List<CongViec> findAll() {
// 		Session session = this.sessionFactory.openSession();
// 		List<CongViec> list = session.createQuery("from Cong_Viec").list();
// 		session.close();
// 		return list;
// 	}

// 	@Override
// 	public void addNew(CongViec cv) {
// 		Session session = this.sessionFactory.openSession();
// 		Transaction tx = session.beginTransaction();
// 		session.persist(cv);
// 		tx.commit();
// 		session.close();
// 	}

// 	@Override
// 	public void update(CongViec cv) {
// 		Session session = this.sessionFactory.openSession();
// 		Transaction tx = session.beginTransaction();
// 		session.update(cv);
// 		tx.commit();
// 		session.close();
// 	}

// 	@Override
// 	public void delete(int ID) {
// 		Session session = this.sessionFactory.openSession();
// 		Transaction pb = session.beginTransaction();
// 		session.delete(session.get(CongViec.class, ID));
// 		pb.commit();
// 		session.close();
// 	}

// 	@Override
// 	public CongViec findByID(int ID) {
// 		Session session = this.sessionFactory.openSession();
// 		CongViec pb = session.get(CongViec.class, ID);
// 		session.close();
// 		return pb;
// 	}

// 	@Override
// 	@SuppressWarnings("unchecked")
// 	public List<CongViec> findAll(int iDisplayStart, int iDisplayLength, String sql) {
// 		Session session = this.sessionFactory.openSession();
// 		List<CongViec> listCongViec = session.createQuery(sql).setFirstResult(iDisplayStart)
// 				.setMaxResults(iDisplayLength).list();
// 		session.close();
// 		return listCongViec;
// 	}

// 	@Override
// 	public String getRecordsTotal() {
// 		Session session = this.sessionFactory.openSession();

// 		String sql = "SELECT COUNT(*) FROM `cong_viec`";
// 		Query query = session.createSQLQuery(sql);

// 		String recordsTotal = query.getSingleResult().toString();
// 		session.close();
// 		return recordsTotal;
// 	}

// 	@Override
// 	public String getRecordsFiltered(String sql) {
// 		Session session = this.sessionFactory.openSession();
// 		Query query = session.createQuery(sql.replace("select cv", "select count(*)"));
// 		String recordsFiltered = query.getSingleResult().toString();
// 		session.close();
// 		return recordsFiltered;
// 	}
//}
