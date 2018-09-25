package fasttrackse.ffse1703.fbms.dao.qttl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fasttrackse.ffse1703.fbms.entity.qttl.*;

@Repository
public class DocumentDAOImpl implements DocumentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Document> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Document",Document.class).list();

	}


	@Override
	public void addNew (Document document) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(document);
	}

	@Override
	public void update(Document document) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(document);
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Document db=session.get(Document.class,id);	
		session.update(db);	
	}


	@Override
	public Document getById(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(Document.class,id);	
	}



}
