package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

public interface NhanVienDAO {
	public HoSoNhanVien getHoSoNhanVien(int nhanVien);
	
	public  DanhGiaBanThan getDanhGiaBanThan(HoSoNhanVien nhanVien , KyDanhGia kyDanhGia);

	public LichDanhGia getLichDanhGiaActive(String phongBan);
	
	public void insertDanhGiaBanThan(DanhGiaBanThan danhgia);

	public void updateDanhGiaBanThan(DanhGiaBanThan danhgia);

	public void deleteDanhGiaBanThan(DanhGiaBanThan danhgia);

	public List<DanhGiaNhanVien> getListDanhGiaNhanVien(HoSoNhanVien nhanVien, KyDanhGia kyDanhGia);
	
	public List<HoSoNhanVien> getListNhanVienPhongBan(String phongBan);
	
	public List<HoSoNhanVien> getListNhanVienLimit(HoSoNhanVien nhanVien, PhongBan phongban);

	public void createDanhGiaNhanVien(List<DanhGiaNhanVien> danhGia);
	
	public void insertDanhGiaNhanVien(DanhGiaNhanVien danhGia);

	public DanhGiaNhanVien getDanhGiaNhanVien(int id);

	public void updateDanhGiaNhanVien(DanhGiaNhanVien danhGia);

	public void deleteDanhGiaNhanVien(DanhGiaNhanVien danhGia);

	public List<DanhGiaNhanVien> getListNhanVienDanhGia(HoSoNhanVien nhanVien, KyDanhGia kyDanhGia);

	public DanhGiaNhanVien getNhanVienDanhGia(int id);

	public TruongPhongDanhGia getDanhGiaCuaTruongPhong(HoSoNhanVien nhanVien, KyDanhGia kyDanhGia);
	
	public void updateListDanhGiaNhanVien(List<DanhGiaNhanVien> danhGia);
	
}
