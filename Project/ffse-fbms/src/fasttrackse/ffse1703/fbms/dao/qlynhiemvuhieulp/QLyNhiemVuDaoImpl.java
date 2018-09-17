package fasttrackse.ffse1703.fbms.dao.qlynhiemvuhieulp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;
@Repository
public class QLyNhiemVuDaoImpl implements QLyNhiemVuDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")

	@Override
	public List<QLyNhiemVuEntity> findAll() {
		Session session = this.sessionFactory.openSession();
		List<QLyNhiemVuEntity> list = session.createQuery("from quan_ly_nhiem_vu ").list();
		session.close();
		return list;
	}

	@Override
	public void addNew(QLyNhiemVuEntity nv) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(nv);
		tx.commit();
		session.close();
	}

	@Override
	public void update(QLyNhiemVuEntity nv) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(nv);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int ID) {
		Session session = this.sessionFactory.openSession();
		Transaction pb = session.beginTransaction();
		session.delete(session.get(QLyNhiemVuEntity.class, ID));
		pb.commit();
		session.close();

	}

	@Override
	public QLyNhiemVuEntity findByTenCongViec(int ID) {
		Session session = this.sessionFactory.openSession();
		QLyNhiemVuEntity pb = session.get(QLyNhiemVuEntity.class, ID);
		session.close();
		return pb;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<QLyNhiemVuEntity> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<QLyNhiemVuEntity> listNhiemVu = session.createQuery(sql).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		session.close();
		return listNhiemVu;
	}

	@Override

	public String getRecordsTotal() {
		Session session = this.sessionFactory.openSession();

		String sql = "SELECT COUNT(*) FROM `quan_ly_nhiem_vu`";
		Query query = session.createSQLQuery(sql);

		String recordsTotal = query.getSingleResult().toString();
		session.close();
		return recordsTotal;
	}

	@Override
	public String getRecordsFiltered(String sql) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(sql.replace("select nv", "select count(*)"));
		String recordsFiltered = query.getSingleResult().toString();
		session.close();
		return recordsFiltered;
	}

}
