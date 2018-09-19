package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Domain;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.KhachHang;

@Repository
@Transactional
public class KhachHangDaoImpl implements KhachHangDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(KhachHang khachHang) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(khachHang);
	}

	@Override
	public KhachHang getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(KhachHang.class, id);
	}

	@Override
	public List<KhachHang> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from KhachHang where status =1", KhachHang.class).list();
	}

	@Override
	public void update(KhachHang khachHang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(khachHang);

	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		KhachHang khachHang = session.get(KhachHang.class, id);
		khachHang.setStatus(0);
		session.update(khachHang);
	}
	@Override
	public int checkKhachHang(String fullname) {
		Session session = sessionFactory.getCurrentSession();
		List<KhachHang> khachhang = session.createQuery("from KhachHang where fullname = '"+fullname+"' and status = 1", KhachHang.class).list();
		
		return  khachhang.size();
	}

	


}
