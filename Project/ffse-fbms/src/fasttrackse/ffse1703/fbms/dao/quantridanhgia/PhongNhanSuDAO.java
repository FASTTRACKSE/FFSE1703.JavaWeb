package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.PhanCongDanhGia;

@Repository
public class PhongNhanSuDAO {

	@Autowired
	public SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// CRUD kỳ đánh giá
	@SuppressWarnings("unchecked")
	public List<KyDanhGia> getListKyDanhGia() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from KyDanhGia").list();
	}

	public void insertKyDanhGia(KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(kyDanhGia);
	}

	public void updateKyDanhGia(KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(kyDanhGia);
	}

	public KyDanhGia getKyDanhGia(int maKy) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(KyDanhGia.class, maKy);
	}

	public void deleteKyDanhGia(KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(kyDanhGia);
	}

	
	// Get mã nhân viên phong ban
	@SuppressWarnings("unchecked")
	public List<Integer> getNhanVienPhongBan(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT ma_nhan_vien FROM ho_so_nhan_vien WHERE ma_phong_ban = ? and ma_chuc_danh = 'NV'";
		return session.createSQLQuery(sql).setParameter(1, phongBan).list();
	}

	
	// Tạo phân công đánh giá
	public void insertPhanCongDanhGia(List<PhanCongDanhGia> phanCong) {
		Session session = sessionFactory.getCurrentSession();
		for (PhanCongDanhGia x : phanCong) {
			session.persist(x);
		}
	}

	// CRUD lịch đánh giá
	@SuppressWarnings("unchecked")
	public List<LichDanhGia> getListLichDanhGia() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from LichDanhGia").list();
	}

	public void insertLichDanhGia(LichDanhGia lichDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(lichDanhGia);
	}

	public LichDanhGia getLichDanhGia(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(LichDanhGia.class, id);
	}

	
	// Active lịch đánh giá
	public void activeLichDanhGia(LichDanhGia lichDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(lichDanhGia);
	}

	// Check lịch đánh giá
	public int checkLichDanhGia(LichDanhGia lichDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from LichDanhGia where kyDanhGia = :kyDG and phongBan = :phongBan")
				.setParameter("kyDG", lichDanhGia.getKyDanhGia()).setParameter("phongBan", lichDanhGia.getPhongBan())
				.list().size();
	}

	// Get list đánh giá bản thân của toàn công ty
	@SuppressWarnings("unchecked")
	public List<DanhGiaBanThan> getListDanhGiaBanThan() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaBanThan").list();
	}
	
	// Get list đánh giá bản thân theo kỳ đánh giá
	@SuppressWarnings("unchecked")
	public List<DanhGiaBanThan> getListDanhGiaBanThanByKyDanhGia(String kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaBanThan where kyDanhGia = :kyDanhGia").setParameter("kyDanhGia", kyDanhGia).list();
	}
	
	// Get list đánh giá bản thân theo phòng ban
	@SuppressWarnings("unchecked")
	public List<DanhGiaBanThan> getListDanhGiaBanThanByPhongBan(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaBanThan where phongBan = :phongBan").setParameter("phongBan", phongBan).list();
	}
	
	// Get list đánh giá bản thân theo kỳ đánh giá và phòng ban
	@SuppressWarnings("unchecked")
	public List<DanhGiaBanThan> getListDanhGiaBanThan(String kyDanhGia, String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaBanThan where kyDanhGia = :kyDanhGia and phongBan = :phongBan").setParameter("kyDanhGia", kyDanhGia).setParameter("phongBan", phongBan).list();
	}
}
