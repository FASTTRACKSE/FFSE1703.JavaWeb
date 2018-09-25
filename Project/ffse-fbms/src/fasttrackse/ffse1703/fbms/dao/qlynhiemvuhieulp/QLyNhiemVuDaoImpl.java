package fasttrackse.ffse1703.fbms.dao.qlynhiemvuhieulp;


import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.DuAnEntityHieuLp;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.LoaicongviecEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.LoaitrangthaiEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;

@Repository
public class QLyNhiemVuDaoImpl implements QLyNhiemVuDao {
		
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<QLyNhiemVuEntity> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<QLyNhiemVuEntity> list = session.createQuery("from QLyNhiemVuEntity where isDelete = 1").getResultList();
		return list;
	}
	@Override
	public void delete(QLyNhiemVuEntity nv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nv);	
	}
	@Override
	public QLyNhiemVuEntity findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		QLyNhiemVuEntity u = (QLyNhiemVuEntity) session.get(QLyNhiemVuEntity.class, id);
		return u;
	}
	@Override
	public void create(QLyNhiemVuEntity nv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(nv);
	}
	
	@Override
	public void update(QLyNhiemVuEntity nv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nv);
	}
	@Override
	public List<LoaitrangthaiEntity> trangThai() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<LoaitrangthaiEntity> cq = cb.createQuery(LoaitrangthaiEntity.class);
		Root<LoaitrangthaiEntity> root = cq.from(LoaitrangthaiEntity.class);
		cq.select(root);
		Query<LoaitrangthaiEntity> query = session.createQuery(cq);
		return query.getResultList();
	}
	@Override
	public List<LoaicongviecEntity> congViec() {
		Session session1 = sessionFactory.getCurrentSession();
		CriteriaBuilder cv1 = session1.getCriteriaBuilder();
		CriteriaQuery<LoaicongviecEntity> cq1 = cv1.createQuery(LoaicongviecEntity.class);
		Root<LoaicongviecEntity> root1 = cq1.from(LoaicongviecEntity.class);
		cq1.select(root1);
		Query<LoaicongviecEntity> query1 = session1.createQuery(cq1);
		return query1.getResultList();
	}
	@Override
	public List<DuAnEntityHieuLp> duAn() {
		Session session2 = sessionFactory.getCurrentSession();
		CriteriaBuilder cv2 = session2.getCriteriaBuilder();
		CriteriaQuery<DuAnEntityHieuLp> cq2 = cv2.createQuery(DuAnEntityHieuLp.class);
		Root<DuAnEntityHieuLp> root2 = cq2.from(DuAnEntityHieuLp.class);
		cq2.select(root2);
		Query<DuAnEntityHieuLp> query2 = session2.createQuery(cq2);
		return query2.getResultList();
	}
	

	
}
