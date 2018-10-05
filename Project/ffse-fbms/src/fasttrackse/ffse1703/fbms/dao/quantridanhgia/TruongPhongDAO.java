package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TrangThaiDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

public interface TruongPhongDAO {

	public List<DanhGiaBanThan> getListDanhGiaBanThan(PhongBan phongBan);
	
	public List<DanhGiaBanThan> getListDanhGiaBanThan(int start, int maxItems, PhongBan phongBan);

	public DanhGiaBanThan getNhanVienTuDanhGia(int id);

	public void updateNhanVienTuDanhGia(DanhGiaBanThan danhGia);

	public List<TruongPhongDanhGia> getListNhanVienPhongBan(PhongBan phongBan);
	
	public List<TruongPhongDanhGia> getListNhanVienPhongBan(int start, int maxItems,PhongBan phongBan);

	public void updateDanhGiaNhanVien(TruongPhongDanhGia danhGia);

	public TruongPhongDanhGia getDanhGiaNhanVien(int id);

	public List<LichDanhGia> getActiveLichDanhGia(PhongBan phongBan);
	
	public void createListNhanVienPhongBan(List<TruongPhongDanhGia> danhGia);

	public List<HoSoNhanVien> getNhanVienPhongBan(PhongBan phongBan);
	
	public List<TrangThaiDanhGia> getTrangThaiDanhGia();
}
