package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;

@Repository
public class PhongNhanSuDAO {

	@Autowired
	public SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

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

	@SuppressWarnings("unchecked")
	public List<Integer> getNhanVienPhongBan(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT ma_nhan_vien FROM ho_so_nhan_vien WHERE ma_phong_ban = '" + phongBan + "'";
		return session.createSQLQuery(sql).list();
	}
}
