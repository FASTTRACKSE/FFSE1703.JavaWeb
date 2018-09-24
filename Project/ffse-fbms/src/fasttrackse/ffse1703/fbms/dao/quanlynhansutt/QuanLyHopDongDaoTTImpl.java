package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HopDongTT;

@Repository
public class QuanLyHopDongDaoTTImpl implements QuanLyHopDongDaoTT {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<HopDongTT> getAllHopDong() {
		Session session = sessionFactory.getCurrentSession();
		List<HopDongTT> listHopDong = session.createQuery("from HopDongTT").getResultList();
		return listHopDong;
	}

	@Override
	public void addHopDong(HopDongTT tt) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(tt);
	}

	@Override
	public void updateHopDong(HopDongTT tt) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tt);
	}

	@Override
	public void removeHopDong(int maHopDong) {
		Session session = sessionFactory.getCurrentSession();
		HopDongTT entity = (HopDongTT) session.get(HopDongTT.class,
				new Integer(maHopDong));
		if (null != entity) {
			session.delete(entity);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HopDongTT> getAllHopDong(int iDisplayStart, int iDisplayLength, String sql) {
		System.out.println(sql);
		Session session = this.sessionFactory.getCurrentSession();
		List<HopDongTT> listHopDongTT = session.createQuery(sql).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		return listHopDongTT;
	}

	@Override
	public String getRecordsTotal(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRecordsFiltered(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAutoId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HopDongTT> getHopDongByPhongBan(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HopDongTT findByMaHopDong(int maHopDong) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(HopDongTT.class, maHopDong);
		
	}

	
}
