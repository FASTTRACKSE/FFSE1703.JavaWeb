package fasttrackse.ffse1703.fbms.dao.QuanLyDuAn;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.KhachHang;
@Repository
public class KhachHangDaoImpl implements KhachHangDao{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(KhachHang khachhang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(khachhang);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<KhachHang> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<KhachHang> list = session.createQuery("FROM KhachHang where is_delete=0 ").getResultList();
		return list;
	}

	@Override
	public KhachHang findById(String maKH) {
		Session session = this.sessionFactory.getCurrentSession();
		KhachHang u = (KhachHang) session.get(KhachHang.class, maKH);
		return u;
	}

	@Override
	public void delete(KhachHang khachhang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(khachhang);
	}

	@Override
	public void update(KhachHang khachhang) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(khachhang);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KhachHang> findAllForPaging(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from khach_hang").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}


}
