package fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.LoaiCongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.TrangThaiMinhHQ;



@Repository
public class QLyNhiemvuMinhHQDaoImpl implements QLyNhiemvuMinhHQDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<CongViecMinhHQ> findAll() {
		Session session = this.sessionFactory.openSession();
		List<CongViecMinhHQ> list = session.createQuery("from CongViecMinhHQ where is_delete ='1'").list();
		session.close();
		return list;
	}

	@Override
	public void addNew(CongViecMinhHQ cv) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(cv);
		tx.commit();
		session.close();
	}

	@Override
	public void update(CongViecMinhHQ cv) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(cv);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(CongViecMinhHQ cv) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(cv);
		tx.commit();
		session.close();
	}

	@Override
	public CongViecMinhHQ findByID(int ID) {
		Session session = this.sessionFactory.openSession();
		CongViecMinhHQ pb = session.get(CongViecMinhHQ.class, ID);
		session.close();
		return pb;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CongViecMinhHQ> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<CongViecMinhHQ> listCongViec = session.createQuery(sql).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		session.close();
		return listCongViec;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThaiMinhHQ> trangThai() {
		Session session = sessionFactory.openSession();
		List<TrangThaiMinhHQ> tt = session.createQuery("from TrangThaiMinhHQ").list();
		session.close();
		return tt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoaiCongViecMinhHQ> loaiCongViec() {
		Session session = sessionFactory.openSession();
		List<LoaiCongViecMinhHQ> cv = session.createQuery("from LoaiCongViecMinhHQ").list();
		session.close();
		return cv;
	}

//	@Override
//	public String getRecordsTotal() {
//		Session session = this.sessionFactory.openSession();
//
//		String sql = "SELECT COUNT(*) FROM `cong_viec`";
//		Query query = session.createSQLQuery(sql);
//
//		String recordsTotal = query.getSingleResult().toString();
//		session.close();
//		return recordsTotal;
//	}
//
//	@Override
//	public String getRecordsFiltered(String sql) {
//		Session session = this.sessionFactory.openSession();
//		Query query = session.createQuery(sql.replace("select cv", "select count(*)"));
//		String recordsFiltered = query.getSingleResult().toString();
//		session.close();
//		return recordsFiltered;
//	}
}

