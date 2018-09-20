package fasttrackse.ffse1703.fbms.dao.qlvn1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.qlvn1.QuanLyVangNghiEntity;

@Repository
public class QuanLyVangNghiDaoImpl implements QuanLyVangNghiDao{
	
	private SessionFactory sessionFactory;

	@Override
	public void addDon(QuanLyVangNghiEntity dn) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(dn);
		
	}
		
	}
	

