package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Framework;
@Repository
@Transactional
public class FrameworkDaoImpl implements FrameworkDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Framework> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Framework where status = 1", Framework.class).list();
	}

	@Override
	public Framework getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Framework fw= session.get(Framework.class,id);
		return fw;
	}

	@Override
	public void add(Framework framework) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(framework);
	}

	@Override
	public void update(Framework framework) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(framework);
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(id);
	}

	@Override
	public int checkNameFramework(String nameFramework) {
		Session session = sessionFactory.getCurrentSession();
		List<Framework> fw = session.createQuery("from Domain where nameFramework = '"+nameFramework+"' and status = 1", Framework.class).list();
		
		return  fw.size();
	}

}
