package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HopDongPikalong;

@Repository
public class HopDongPikalongDaoImpl implements HopDongPikalongDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HopDongPikalong> listHopDong() {
		Session session = this.sessionFactory.getCurrentSession();
		List<HopDongPikalong> listHopDong = session.createQuery("from HopDongPikalong").list();
		return listHopDong;
	}
	
	@Override
	public void insert(HopDongPikalong hd) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(hd);
	}
}
