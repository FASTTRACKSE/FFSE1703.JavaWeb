package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

public interface NhanVienDAO {
	public DanhGiaBanThan getDanhGiaBanThan(int id);

	public LichDanhGia getLichDanhGiaActive(String phongBan);
	
	public void insertDanhGiaBanThan(DanhGiaBanThan danhgia);

	public void updateDanhGiaBanThan(DanhGiaBanThan danhgia);

	public void deleteDanhGiaBanThan(DanhGiaBanThan danhgia);

	public List<DanhGiaNhanVien> getListPhanCongDanhGia(int id);
	
	public List<HoSoNhanVien> getListNhanVienPhongBan(String phongBan);
	
	public List<HoSoNhanVien> getListNhanVienLimit(int id, String phongBan);

	public void createDanhGiaNhanVien(List<DanhGiaNhanVien> danhGia);
	
	public void insertDanhGiaNhanVien(DanhGiaNhanVien danhGia);

	public DanhGiaNhanVien getDanhGiaNhanVien(int id);

	public void updateDanhGiaNhanVien(DanhGiaNhanVien danhGia);

	public void deleteDanhGiaNhanVien(DanhGiaNhanVien danhGia);

	public List<DanhGiaNhanVien> getListNhanVienDanhGia(int maNhanVien);

	public DanhGiaNhanVien getNhanVienDanhGia(int id);

	public TruongPhongDanhGia getDanhGiaCuaTruongPhong(int maNhanVien);
}
