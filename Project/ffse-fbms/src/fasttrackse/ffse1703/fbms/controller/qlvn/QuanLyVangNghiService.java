package fasttrackse.ffse1703.fbms.service.qlvn;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlvn.LyDoXinNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn.TrangThai;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

public interface QuanLyVangNghiService {
	public List<ThongKeDonXinPhep> danhSachXinNghiChoDuyet();

	public List<ThongKeDonXinPhep> danhSachXinNghiDuyet();

	public List<ThongKeDonXinPhep> danhSachXinNghiNhap();
	
	public List<ThongKeDonXinPhep> danhSachXinNghiTuChoi();
	
	public void create(ThongKeDonXinPhep thongKeDonXinPhep);
	
	public void createWalk(ThongKeDonXinPhep thongKeDonXinPhep);
	
	public void createBrowse(ThongKeDonXinPhep thongKeDonXinPhep);
	
	public void createfeedback(ThongKeDonXinPhep thongKeDonXinPhep);
	
	public List<LyDoXinNghi> loadAllLyDo();
	
	public List<TrangThai> loadAllTrangThai();
	
	public List<HoSoNhanVien> loadAllHoSo();
	
	public ThongKeDonXinPhep findById(int id);
	
	public void delete(int id);
	
	public void updateNhap(ThongKeDonXinPhep thongKeDonXinPhep) ;
}

