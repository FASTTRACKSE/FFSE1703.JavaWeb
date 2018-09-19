package fasttrackse.ffse1703.fbms.dao.QuanLyDuAn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Domain;

@Repository
public class DomainDaoImpl implements DomainDao{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(Domain domain) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(domain);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Domain> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Domain> list = session.createQuery("FROM Domain where is_delete=0").getResultList();

		return list;
	}

	@Override
	public Domain findById(String maNghiepVu) {
		Session session = this.sessionFactory.getCurrentSession();
		Domain u = (Domain) session.get(Domain.class, maNghiepVu);
		return u;
	}

	@Override
	public void delete(Domain domain) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domain);
	}

	@Override
	public void update(Domain domain) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(domain);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from nghiep_vu").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}


}
