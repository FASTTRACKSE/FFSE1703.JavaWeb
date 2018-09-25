package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinBangCapTT;

@Repository
public class ThongTinBangCapDaoTTImpl implements ThongTinBangCapDaoTT {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addThongTinBangCap(ThongTinBangCapTT ttbc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(ttbc);
	}

	@Override
	public void updateThongTinBangCap(ThongTinBangCapTT ttbc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(ttbc);
	}

	@Override
	public void deleteThongTinBangCap(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ThongTinBangCapTT ttbc = (ThongTinBangCapTT) session.load(ThongTinBangCapTT.class, id);
		if (null != ttbc) {
			session.delete(ttbc);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThongTinBangCapTT> ListBangCap() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<ThongTinBangCapTT> listBangCap = session.createQuery("from ThongTinBangCapTT").getResultList();
		return listBangCap;
	}

	@Override
	public ThongTinBangCapTT findByBangCap(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(ThongTinBangCapTT.class, id);
	}

	@Override
	public HoSoNhanVienTT findByMaNhanVien(int maNhanVien) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(HoSoNhanVienTT.class, maNhanVien);
	}

}
