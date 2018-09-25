package fasttrackse.ffse1703.fbms.service.quantridanhgia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quantridanhgia.TruongPhongDAO;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;

@Service
public class TruongPhongServiceImpl implements TruongPhongService {

	@Autowired
	TruongPhongDAO dao;

	public void setDao(TruongPhongDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public DanhGiaBanThan getNhanVienTuDanhGia(int id) {
		return dao.getNhanVienTuDanhGia(id);
	}

	@Override
	@Transactional
	public List<TruongPhongDanhGia> getListNhanVienPhongBan(String phongBan) {
		return dao.getListNhanVienPhongBan(phongBan);
	}

	@Override
	@Transactional
	public void insertDanhGiaNhanVien(TruongPhongDanhGia danhGia) {
		dao.insertDanhGiaNhanVien(danhGia);
	}

	@Override
	@Transactional
	public TruongPhongDanhGia getDanhGiaNhanVien(int id) {
		return dao.getDanhGiaNhanVien(id);
	}

	@Override
	@Transactional
	public void updateDanhGiaNhanVien(TruongPhongDanhGia danhGia) {
		dao.updateDanhGiaNhanVien(danhGia);
	}

	@Override
	@Transactional
	public void deleteDanhGiaNhanVien(TruongPhongDanhGia danhGia) {
		dao.deleteDanhGiaNhanVien(danhGia);
	}

}
