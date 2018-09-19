package fasttrackse.ffse1703.fbms.dao.QuanLyDuAn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Vendor;

@Repository
public class VendorDaoImpl implements VendorDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Vendor> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Vendor where isDelete =0",Vendor.class).list();

	}


	@Override
	public void addNew(Vendor vd) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(vd);
	}

	@Override
	public void update(Vendor vd) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(vd);
	}

	@Override
	public void delete(String maVendor) {
		Session session = this.sessionFactory.getCurrentSession();
		Vendor db=session.get(Vendor.class,maVendor);	
		db.setIs_delete(1);
		session.update(db);	
	}


	@Override
	public Vendor getById(String maVendor) {
		Session session=this.sessionFactory.getCurrentSession();
		return session.get(Vendor.class,maVendor);	
	}

	@Override
	public void setIsDelete(String maVendor) {
		Session session = this.sessionFactory.getCurrentSession();
		Vendor db=session.get(Vendor.class,maVendor);	
		db.setIs_delete(0);
		session.update(db);
	}

}
