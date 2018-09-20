package fasttrackse.ffse1703.fbms.dao.qlvn1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import fasttrackse.ffse1703.fbms.entity.qlvn1.QuanLyVangNghiEntity;

public class QuanLyVangNghiDaoImpl implements QuanLyVangNghiDao{
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<QuanLyVangNghiEntity> findAll() {
		Session session = this.sessionFactory.openSession();
		List<QuanLyVangNghiEntity> list = session.createQuery("from don_nghi ").list();
		session.close();
		return list;
	}

	@Override
	public void addNew(QuanLyVangNghiEntity nv) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(nv);
		tx.commit();
		session.close();
		
	}

	@Override
	public QuanLyVangNghiEntity findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		QuanLyVangNghiEntity dn = session.get(QuanLyVangNghiEntity.class, id);
		return dn;
	}

}
