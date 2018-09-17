package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.LoaiHopDongTT;

@Repository
public class LoaiHopDongDaoTTImpl implements LoaiHopDongDaoTT {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<LoaiHopDongTT> listLoaiHopDongTT() {
		Session session = this.sessionFactory.getCurrentSession();
		List<LoaiHopDongTT> list = session.createQuery("from LoaiHopDongTT").getResultList();
		return list;
	}

}