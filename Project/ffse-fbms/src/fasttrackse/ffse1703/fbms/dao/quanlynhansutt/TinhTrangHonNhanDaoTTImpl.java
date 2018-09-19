package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.TinhTrangHonNhanTT;

public class TinhTrangHonNhanDaoTTImpl implements TinhTrangHonNhanDaoTT {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<TinhTrangHonNhanTT> getAllTinhTrangHonNhan() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TinhTrangHonNhan");
		List<TinhTrangHonNhanTT> listTinhTrangHonNhan = query.list();

		return listTinhTrangHonNhan;
	}

}
