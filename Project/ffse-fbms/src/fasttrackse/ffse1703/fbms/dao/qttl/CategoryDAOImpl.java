package fasttrackse.ffse1703.fbms.dao.qttl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fasttrackse.ffse1703.fbms.entity.qttl.*;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println(category.getMa_danh_muc());
		session.persist(category);

	}

	@Override
	public List<Category> listCategory() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Category", Category.class).list();
	}

	@Override
	public Category findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category u = (Category) session.get(Category.class, id);
		return u;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findById(id));
	}

	@Override
	public void update(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(category);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from danh_muc").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}

}