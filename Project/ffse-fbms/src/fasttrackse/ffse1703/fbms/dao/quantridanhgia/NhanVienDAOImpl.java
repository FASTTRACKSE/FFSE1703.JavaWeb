package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Repository
public class NhanVienDAOImpl implements NhanVienDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DanhGiaBanThan getDanhGiaBanThan(HoSoNhanVien nhanVien, KyDanhGia kyDanhGia) {
		DanhGiaBanThan danhGia = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DanhGiaBanThan where nhanVien = :nhanVien and kyDanhGia = :kyDanhGia")
				.setParameter("nhanVien", nhanVien).setParameter("kyDanhGia", kyDanhGia);
		try {
			danhGia = (DanhGiaBanThan) query.getSingleResult();
		} catch (NoResultException e) {
		}
		return danhGia;
	}

	@Override
	public void insertDanhGiaBanThan(DanhGiaBanThan danhgia) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(danhgia);
	}

	@Override
	public void updateDanhGiaBanThan(DanhGiaBanThan danhgia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhgia);
	}

	@Override
	public void deleteDanhGiaBanThan(DanhGiaBanThan danhgia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhgia);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaNhanVien> getListDanhGiaNhanVien(int maNhanVien, KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaNhanVien where nhanVienDanhGia = :nhanVien and kyDanhGia = :kyDanhGia")
				.setParameter("nhanVien", maNhanVien).setParameter("kyDanhGia", kyDanhGia).list();
	}

	@Override
	public void insertDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(danhGia);
	}

	@Override
	public DanhGiaNhanVien getDanhGiaNhanVien(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(DanhGiaNhanVien.class, id);
	}

	@Override
	public void updateDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhGia);
	}

	@Override
	public void deleteDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhGia);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public TruongPhongDanhGia getDanhGiaCuaTruongPhong(int maNhanVien, KyDanhGia kyDanhGia) throws NoResultException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery(
						"from TruongPhongDanhGia where nhanVien.maNhanVien = :maNhanVien and kyDanhGia = :kyDanhGia")
				.setParameter("maNhanVien", maNhanVien).setParameter("kyDanhGia", kyDanhGia);
		if (query.list().size() > 0) {
			return (TruongPhongDanhGia) query.getSingleResult();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaNhanVien> getListNhanVienDanhGia(int maNhanVien, KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		return session
				.createQuery("from DanhGiaNhanVien where nhanVien.maNhanVien = :nhanVien and kyDanhGia = :kyDanhGia")
				.setParameter("nhanVien", maNhanVien).setParameter("kyDanhGia", kyDanhGia).list();
	}

	@Override
	public DanhGiaNhanVien getNhanVienDanhGia(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(DanhGiaNhanVien.class, id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public LichDanhGia getLichDanhGiaActive(String phongBan) throws NoResultException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from LichDanhGia where phongBan.maPhongBan = :phongBan and isActive = 1")
				.setParameter("phongBan", phongBan);
		if (query.list().size() > 0) {
			return (LichDanhGia) query.getSingleResult();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> getListNhanVienLimit(int id, String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session
				.createQuery("from HoSoNhanVien where phongBan.maPhongBan = :phongBan and chucDanh.maChucDanh = 'NV'")
				.setParameter("phongBan", phongBan).setFirstResult(id).setMaxResults(5).list();
	}

	@Override
	public void createDanhGiaNhanVien(List<DanhGiaNhanVien> danhGia) {
		Session session = sessionFactory.getCurrentSession();
		for (DanhGiaNhanVien x : danhGia) {
			session.persist(x);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> getListNhanVienPhongBan(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session
				.createQuery("from HoSoNhanVien where phongBan.maPhongBan = :phongBan and chucDanh.maChucDanh = 'NV'")
				.setParameter("phongBan", phongBan).list();
	}

	@Override
	public HoSoNhanVien getHoSoNhanVien(int nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(HoSoNhanVien.class, nhanVien);
	}

}
