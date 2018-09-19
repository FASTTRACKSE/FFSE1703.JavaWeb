package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.DanTocTT;

@Repository
public class DanTocDaoImplTT implements DanTocDaoTT {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<DanTocTT> listAllDanToc() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from DanTocTT");
		@SuppressWarnings("unchecked")
		List<DanTocTT> listDanToc = query.list();

		return listDanToc;
	}

}
