package fasttrackse.ffse1703.fbms.service.quantridanhgia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quantridanhgia.TruongPhongDAO;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TrangThaiDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

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
	public List<TruongPhongDanhGia> getListNhanVienPhongBan(PhongBan phongBan, KyDanhGia kyDanhGia) {
		return dao.getListNhanVienPhongBan(phongBan, kyDanhGia);
	}

	@Override
	@Transactional
	public void updateDanhGiaNhanVien(TruongPhongDanhGia danhGia) {
		dao.updateDanhGiaNhanVien(danhGia);
	}

	@Override
	@Transactional
	public TruongPhongDanhGia getDanhGiaNhanVien(int id) {
		return dao.getDanhGiaNhanVien(id);
	}

	@Override
	@Transactional
	public void createListNhanVienPhongBan(List<TruongPhongDanhGia> danhGia) {
		dao.createListNhanVienPhongBan(danhGia);
	}

	@Override
	@Transactional
	public void updateNhanVienTuDanhGia(DanhGiaBanThan danhGia) {
		dao.updateNhanVienTuDanhGia(danhGia);
	}

	@Override
	@Transactional
	public List<DanhGiaBanThan> getListDanhGiaBanThan(PhongBan phongBan, KyDanhGia kyDanhGia) {
		return dao.getListDanhGiaBanThan(phongBan, kyDanhGia);
	}

	@Override
	@Transactional
	public List<HoSoNhanVien> getNhanVienPhongBan(PhongBan phongBan) {
		return dao.getNhanVienPhongBan(phongBan);
	}

	@Override
	@Transactional
	public List<LichDanhGia> getActiveLichDanhGia(PhongBan phongBan) {
		return dao.getActiveLichDanhGia(phongBan);
	}

	@Override
	@Transactional
	public List<DanhGiaBanThan> getListDanhGiaBanThan(int start, int maxItems, PhongBan phongBan, KyDanhGia kyDanhGia) {
		return dao.getListDanhGiaBanThan(start, maxItems, phongBan,kyDanhGia);
	}

	@Override
	@Transactional
	public List<TruongPhongDanhGia> getListNhanVienPhongBan(int start, int maxItems, PhongBan phongBan, KyDanhGia kyDanhGia) {
		return dao.getListNhanVienPhongBan(phongBan, kyDanhGia);
	}

	@Override
	@Transactional
	public List<TrangThaiDanhGia> getTrangThaiDanhGia() {
		return dao.getTrangThaiDanhGia();
	}

	@Override
	public LichDanhGia checkActiveLichDanhGia(String phongBan) {
		return dao.checkActiveLichDanhGia(phongBan);
	}

}
