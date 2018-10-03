package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

public interface TruongPhongDAO {

	public List<DanhGiaBanThan> getListDanhGiaBanThan(String phongBan);
	
	public List<DanhGiaBanThan> getListDanhGiaBanThan(int start, int maxItems, String phongBan);

	public DanhGiaBanThan getNhanVienTuDanhGia(int id);

	public void updateNhanVienTuDanhGia(DanhGiaBanThan danhGia);

	public List<TruongPhongDanhGia> getListNhanVienPhongBan(String phongBan);
	
	public List<TruongPhongDanhGia> getListNhanVienPhongBan(int start, int maxItems,String phongBan);

	public void updateDanhGiaNhanVien(TruongPhongDanhGia danhGia);

	public TruongPhongDanhGia getDanhGiaNhanVien(int id);

	public LichDanhGia getActiveLichDanhGia(String phongBan);
	
	public void createListNhanVienPhongBan(List<TruongPhongDanhGia> danhGia);

	public List<HoSoNhanVien> getNhanVienPhongBan(String phongBan);
}
