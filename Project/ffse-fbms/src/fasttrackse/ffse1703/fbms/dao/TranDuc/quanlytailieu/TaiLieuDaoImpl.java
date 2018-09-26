package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

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
		sql.setFirstResult((int) Math.ceil(start));
		sql.setMaxResults((int) Math.ceil(limit));
		List<TaiLieu> list = sql.getResultList();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhongBan> listPhongBan() {
		Session session = this.sessionFactory.openSession();
		List<PhongBan> list = session.createQuery("from PhongBan").list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhMuc> listDanhMuc() {
		Session session = this.sessionFactory.openSession();
		List<DanhMuc> list = session.createQuery("from DanhMuc").list();
		session.close();
		return list;
	}

}
