package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;

@Repository
public class TruongPhongDAOImpl implements TruongPhongDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public DanhGiaBanThan getNhanVienTuDanhGia(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TruongPhongDanhGia> getListNhanVienPhongBan(String phongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertDanhGiaNhanVien(TruongPhongDanhGia danhGia) {
		// TODO Auto-generated method stub

	}

	@Override
	public TruongPhongDanhGia getDanhGiaNhanVien(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDanhGiaNhanVien(TruongPhongDanhGia danhGia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDanhGiaNhanVien(TruongPhongDanhGia danhGia) {
		// TODO Auto-generated method stub

	}

}
