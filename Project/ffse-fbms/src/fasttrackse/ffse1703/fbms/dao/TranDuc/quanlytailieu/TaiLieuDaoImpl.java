package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;

@Repository
public class TaiLieuDaoImpl implements TaiLieuDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSession(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaiLieu> listAll() {
		Session session = this.sessionFactory.openSession();
		List<TaiLieu> list = session.createQuery("from TaiLieu").list();
		session.close();
		return list;
	}

	@Override
	public void addTL(TaiLieu tl) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(tl);
		tx.commit();
		session.close();
	}

	@Override
	public void updateTL(TaiLieu tl) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(tl);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteTL(String maTL) {
		Session session = this.sessionFactory.openSession();
		Transaction tl = session.beginTransaction();
		session.delete(session.get(TaiLieu.class, maTL));
		tl.commit();
		session.close();
	}

	@Override
	public TaiLieu getTLbyID(String maTL) {
		Session session = this.sessionFactory.openSession();
		TaiLieu tl = session.get(TaiLieu.class, maTL);
		session.close();
		return tl;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaiLieu> listAll(int start, int limit) {
		Session session = this.sessionFactory.openSession();
		Query sql = session.createQuery("from TaiLieu");
		sql.setFirstResult(start);
		sql.setMaxResults(limit);
		List<TaiLieu> list = sql.getResultList();
		session.close();
		return list;
	}

	@Override
	public String getRecordsTotal() {
		Session session = this.sessionFactory.openSession();
		String sql = "SELECT COUNT(*) FROM `tai_lieu`";
		Query query = session.createSQLQuery(sql);
		String recordsTotal = query.getSingleResult().toString();
		session.close();
		return recordsTotal;
	}

}
