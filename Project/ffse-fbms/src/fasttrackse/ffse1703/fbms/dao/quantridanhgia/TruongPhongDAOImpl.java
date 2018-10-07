package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TrangThaiDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@Repository
public class TruongPhongDAOImpl implements TruongPhongDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public DanhGiaBanThan getNhanVienTuDanhGia(int id) throws NoResultException {
		Session session = sessionFactory.getCurrentSession();
		return session.get(DanhGiaBanThan.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TruongPhongDanhGia> getListNhanVienPhongBan(PhongBan phongBan, KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from TruongPhongDanhGia where phongBan = :phongBan and kyDanhGia = :kyDanhGia")
				.setParameter("phongBan", phongBan).setParameter("kyDanhGia", kyDanhGia).list();
	}

	@Override
	public void updateDanhGiaNhanVien(TruongPhongDanhGia danhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhGia);
	}

	@Override
	public TruongPhongDanhGia getDanhGiaNhanVien(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TruongPhongDanhGia.class, id);
	}

	@Override
	public void createListNhanVienPhongBan(List<TruongPhongDanhGia> danhGia) {
		Session session = sessionFactory.getCurrentSession();
		for (TruongPhongDanhGia x : danhGia) {
			session.persist(x);
		}
	}

	@Override
	public void updateNhanVienTuDanhGia(DanhGiaBanThan danhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhGia);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThan(PhongBan phongBan, KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaBanThan where phongBan = :phongBan and kyDanhGia = :kyDanhGia and trangThai.maTrangThai = 2")
				.setParameter("phongBan", phongBan).setParameter("kyDanhGia", kyDanhGia).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> getNhanVienPhongBan(PhongBan phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from HoSoNhanVien where phongBan = :phongBan and chucDanh.maChucDanh = 'NV'")
				.setParameter("phongBan", phongBan).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LichDanhGia> getActiveLichDanhGia(PhongBan phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from LichDanhGia where phongBan = :phongBan and isActive = 1")
				.setParameter("phongBan", phongBan).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThan(int start, int maxItems, PhongBan phongBan, KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaBanThan where phongBan = :phongBan and kyDanhGia = :kyDanhGia and trangThai.maTrangThai = 2").setFirstResult(start)
				.setMaxResults(maxItems).setParameter("phongBan", phongBan).setParameter("kyDanhGia", kyDanhGia).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TruongPhongDanhGia> getListNhanVienPhongBan(int start, int maxItems, PhongBan phongBan, KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from TruongPhongDanhGia where phongBan = :phongBan and kyDanhGia = :kyDanhGia").setFirstResult(start)
				.setMaxResults(maxItems).setParameter("phongBan", phongBan).setParameter("kyDanhGia", kyDanhGia).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThaiDanhGia> getTrangThaiDanhGia() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from TrangThaiDanhGia").list();
	}
	@SuppressWarnings("rawtypes")
	@Override
	public LichDanhGia checkActiveLichDanhGia(String phongBan) throws NoResultException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from LichDanhGia where phongBan.maPhongBan = :phongBan and isActive = 1")
				.setParameter("phongBan", phongBan);
		if (query.list().size() > 0) {
			return (LichDanhGia) query.getSingleResult();
		}
		return null;
	}
}
