package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaBanThan> getDanhGiaBanThan(HoSoNhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaBanThan where nhanVien = :maNhanVien")
				.setParameter("maNhanVien", nhanVien).list();
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
	public List<DanhGiaNhanVien> getListPhanCongDanhGia(int maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaNhanVien where nhanVienDanhGia = :nhanVien")
				.setParameter("nhanVien", maNhanVien).list();
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

	@Override
	public TruongPhongDanhGia getDanhGiaCuaTruongPhong(int maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		return (TruongPhongDanhGia) session
				.createQuery("from TruongPhongDanhGia where nhanVien.maNhanVien = :maNhanVien")
				.setParameter("maNhanVien", maNhanVien).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaNhanVien> getListNhanVienDanhGia(int maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaNhanVien where nhanVien.maNhanVien = :nhanVien")
				.setParameter("nhanVien", maNhanVien).list();
	}

	@Override
	public DanhGiaNhanVien getNhanVienDanhGia(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(DanhGiaNhanVien.class, id);
	}

	@Override
	public LichDanhGia getLichDanhGiaActive(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.byNaturalId(LichDanhGia.class).using("phongBan", phongBan).using("isActive", 1).load();
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
