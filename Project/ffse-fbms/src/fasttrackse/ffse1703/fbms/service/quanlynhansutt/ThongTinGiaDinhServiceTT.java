package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinGiaDinhTT;

public interface ThongTinGiaDinhServiceTT {
	public void addGiaDinh(ThongTinGiaDinhTT p);

	public void updateGiaDinh(ThongTinGiaDinhTT p);

	public ThongTinGiaDinhTT getGiaDinhById(int id);

	public HoSoNhanVienTT getHoSoNhanVienById(int maNhanVien);

	public void removeGiaDinh(int id);

	public List<ThongTinGiaDinhTT> viewOne(int maNhanVien);

	int checkQuanHe(String quanHe, int maNhanVien);

}
