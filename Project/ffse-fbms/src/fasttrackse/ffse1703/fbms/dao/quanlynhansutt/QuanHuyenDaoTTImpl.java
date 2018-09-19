package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.QuanHuyenTT;

@Repository
public class QuanHuyenDaoTTImpl implements QuanHuyenDaoTT {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<QuanHuyenTT> listQuanHuyen() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from QuanHuyenTT");
		@SuppressWarnings("unchecked")
		List<QuanHuyenTT> listQuanHuyen = query.list();

		return listQuanHuyen;
	}

}
