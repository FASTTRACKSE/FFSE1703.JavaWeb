package fasttrackse.ffse1703.fbms.dao.QuanLyDuAn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Database;

@Repository
public class DatabaseDaoImpl implements DatabaseDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Database> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Database where isDelete =0",Database.class).list();

	}

	@Override
	public void delete(String maDatabase) {
		Session session = this.sessionFactory.getCurrentSession();
		Database db=session.get(Database.class,maDatabase);	
		db.setIs_delete(1);
		session.update(db);	
	}

	@Override
	public void save(Database database) {
		 for (int i = 0; i < 5; i++) {
			 database = new Database();
			 database.setMa_database("DB" + i);
		
	      }
		
		Session session=this.sessionFactory.getCurrentSession();
		session.save(database);
		
	}

	@Override
	public Database getById(String maDatabase) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(Database.class,maDatabase);		
	}

	@Override
	public void update(Database database) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(database);		
	}

	@Override
	public void setIsDelete(String maDatabase) {
		Session session = this.sessionFactory.getCurrentSession();
		Database db=session.get(Database.class,maDatabase);	
		db.setIs_delete(0);
		session.update(db);	
	}

}
