package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Vendor;

@Repository
public class VendorDAOImpl implements VendorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Vendor> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Vendor where status = 1", Vendor.class).list();
		
	}

	@Override
	public Vendor findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Vendor Vendor = session.get(Vendor.class, id);
		return Vendor;

	}
	@Override
	public int checkVendor(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Vendor> dm = session.createQuery("from Vendor where nameVendor = '"+name+"'", Vendor.class).list();
		
		return  dm.size();
	}

	@Override
	public void addNew(Vendor Vendor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(Vendor);

	}

	@Override
	public void update(Vendor Vendor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Vendor);
	}

	@Override
	public void delete(Vendor Vendor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Vendor);

	}

}
