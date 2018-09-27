package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinGiaDinhTT;

public interface ThongTinGiaDinhDaoTT {
	public void addGiaDinh(ThongTinGiaDinhTT p);
	public void updateGiaDinh(ThongTinGiaDinhTT p);
	public ThongTinGiaDinhTT getGiaDinhById(int id);
	public void removeGiaDinh(int id);
	public int total();
	public List<ThongTinGiaDinhTT> viewOne(int maNhanVien);
	int checkQuanHe(String quanHe, int maNhanVien);

}
