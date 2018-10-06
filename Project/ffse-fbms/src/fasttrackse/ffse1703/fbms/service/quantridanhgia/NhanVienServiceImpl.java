package fasttrackse.ffse1703.fbms.service.quantridanhgia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quantridanhgia.NhanVienDAO;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Service
public class NhanVienServiceImpl implements NhanVienService {

	@Autowired
	NhanVienDAO dao;

	public void setDao(NhanVienDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public DanhGiaBanThan getDanhGiaBanThan(HoSoNhanVien nhanVien, KyDanhGia kyDanhGia) {
		return dao.getDanhGiaBanThan(nhanVien, kyDanhGia);
	}

	@Override
	@Transactional
	public void insertDanhGiaBanThan(DanhGiaBanThan danhgia) {
		dao.insertDanhGiaBanThan(danhgia);

	}

	@Override
	@Transactional
	public void updateDanhGiaBanThan(DanhGiaBanThan danhgia) {
		dao.updateDanhGiaBanThan(danhgia);
	}

	@Override
	@Transactional
	public void deleteDanhGiaBanThan(DanhGiaBanThan danhgia) {
		dao.deleteDanhGiaBanThan(danhgia);
	}

	@Override
	@Transactional
	public void insertDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		dao.insertDanhGiaNhanVien(danhGia);
	}

	@Override
	@Transactional
	public DanhGiaNhanVien getDanhGiaNhanVien(int id) {
		return dao.getDanhGiaNhanVien(id);
	}

	@Override
	@Transactional
	public void updateDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		dao.updateDanhGiaNhanVien(danhGia);
	}

	@Override
	@Transactional
	public void deleteDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		dao.deleteDanhGiaNhanVien(danhGia);
	}

	@Override
	@Transactional
	public TruongPhongDanhGia getDanhGiaCuaTruongPhong(int maNhanVien, KyDanhGia kyDanhGia) {
		return dao.getDanhGiaCuaTruongPhong(maNhanVien, kyDanhGia);
	}

	@Transactional
	@Override
	public List<DanhGiaNhanVien> getListNhanVienDanhGia(int maNhanVien, KyDanhGia kyDanhGia) {
		return dao.getListNhanVienDanhGia(maNhanVien, kyDanhGia);
	}

	@Transactional
	@Override
	public DanhGiaNhanVien getNhanVienDanhGia(int id) {
		return dao.getNhanVienDanhGia(id);
	}

	@Transactional
	@Override
	public LichDanhGia getLichDanhGiaActive(String phongBan) {
		return dao.getLichDanhGiaActive(phongBan);
	}

	@Override
	@Transactional
	public List<HoSoNhanVien> getListNhanVienLimit(int id, String phongBan) {
		return dao.getListNhanVienLimit(id, phongBan);
	}

	@Override
	@Transactional
	public void createDanhGiaNhanVien(List<DanhGiaNhanVien> danhGia) {
		dao.createDanhGiaNhanVien(danhGia);
	}

	@Override
	@Transactional
	public List<HoSoNhanVien> getListNhanVienPhongBan(String phongBan) {
		return dao.getListNhanVienPhongBan(phongBan);
	}

	@Override
	@Transactional
	public HoSoNhanVien getHoSoNhanVien(int nhanVien) {
		return dao.getHoSoNhanVien(nhanVien);
	}

	@Override
	@Transactional
	public List<DanhGiaNhanVien> getListDanhGiaNhanVien(int id, KyDanhGia kyDanhGia) {
		return dao.getListDanhGiaNhanVien(id, kyDanhGia);
	}

}
