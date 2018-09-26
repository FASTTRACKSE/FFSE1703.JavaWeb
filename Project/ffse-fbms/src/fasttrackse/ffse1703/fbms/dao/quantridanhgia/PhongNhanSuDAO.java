package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;

public interface PhongNhanSuDAO {

	public List<KyDanhGia> getListKyDanhGia();

	public void insertKyDanhGia(KyDanhGia kyDanhGia);

	public void updateKyDanhGia(KyDanhGia kyDanhGia);

	public KyDanhGia getKyDanhGia(int maKy);

	public void deleteKyDanhGia(KyDanhGia kyDanhGia);

	public List<Integer> getNhanVienPhongBan(String phongBan);

	public List<LichDanhGia> getListLichDanhGia();

	public int checkLichDanhGia(LichDanhGia lichDanhGia);

	public void insertLichDanhGia(LichDanhGia lichDanhGia);

	public LichDanhGia getLichDanhGia(int id);
	
	public int checkActiveLichDanhGia();

	public int checkCompleteLichDanhGia();
	
	public void activeLichDanhGia(LichDanhGia lichDanhGia);

	public void insertPhanCongDanhGia(List<DanhGiaNhanVien> pc);

	public List<DanhGiaBanThan> getListDanhGiaBanThan();

	public List<DanhGiaBanThan> getListDanhGiaBanThanByKyDanhGia(String kyDanhGia);

	public List<DanhGiaBanThan> getListDanhGiaBanThanByPhongBan(String phongBan);

	public List<DanhGiaBanThan> getListDanhGiaBanThan(String kyDanhGia, String phongBan);

}
