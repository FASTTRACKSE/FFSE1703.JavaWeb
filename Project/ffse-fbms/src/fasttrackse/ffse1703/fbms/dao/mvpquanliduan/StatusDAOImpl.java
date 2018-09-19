package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Status;
@Repository
public class StatusDAOImpl implements StatusDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Status> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Status where status = 1", Status.class).list();
	}
	@Override
	public int checkNameStatus(String nameStatus) {
		Session session = sessionFactory.getCurrentSession();
		List<Status> dm = session.createQuery("from Status where nameStatus = '"+nameStatus+"' and status = 1", Status.class).list();
		
		return  dm.size();
	}

	@Override
	public Status findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Status dm = session.get(Status.class, id);
		return dm;
	}

	@Override
	public void addNew(Status Status) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(Status);

	}

	@Override
	public void update(Status status) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(status);
	}

	@Override
	public void delete(Status status) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(status);

	}
}
