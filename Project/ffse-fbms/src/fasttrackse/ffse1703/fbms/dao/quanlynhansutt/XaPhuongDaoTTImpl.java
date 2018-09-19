package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.XaPhuongTT;

public class XaPhuongDaoTTImpl implements XaPhuongDaoTT {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<XaPhuongTT> listXaPhuong() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from XaPhuongTT");
		@SuppressWarnings("unchecked")
		List<XaPhuongTT> listXaPhuong = query.list();

		return listXaPhuong;
	}

}
