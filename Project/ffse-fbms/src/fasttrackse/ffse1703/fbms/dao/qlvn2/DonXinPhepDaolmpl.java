package fasttrackse.ffse1703.fbms.dao.qlvn2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
@Repository
public class DonXinPhepDaolmpl implements DonXinPhepDao{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<DonXinPhepEntity> danhsachnhap003() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity",DonXinPhepEntity.class).list();
	}

	
	@Override
	public List<DonXinPhepEntity> danhsachdaduyet003() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity",DonXinPhepEntity.class).list();
	}
	@Override
	public List<DonXinPhepEntity> danhsachchoduyet003() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity",DonXinPhepEntity.class).list();
	}
	@Override
	public List<DonXinPhepEntity> danhsachbituchoi003() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity",DonXinPhepEntity.class).list();
	}
}
