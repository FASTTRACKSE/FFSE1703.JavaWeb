package fasttrackse.ffse1703.fbms.service.qlvn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fasttrackse.ffse1703.fbms.dao.qlvn.QuanLyVangNghiDao;
import fasttrackse.ffse1703.fbms.entity.qlvn.LyDoXinNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn.TrangThai;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
@Service
@Transactional
public class QuanLyVangNghiServiceIpml implements QuanLyVangNghiService {
	@Autowired
	private QuanLyVangNghiDao quanLyVangNghiDao;
	
	public void setQuanLyVangNghiDao(QuanLyVangNghiDao quanLyVangNghiDao) {
		this.quanLyVangNghiDao = quanLyVangNghiDao;
	}
	
	public List<ThongKeDonXinPhep> danhSachXinNghiChoDuyet() {
		return this.quanLyVangNghiDao.danhSachXinNghiChoDuyet();
	}

	public List<ThongKeDonXinPhep> danhSachXinNghiDuyet() {
		return this.quanLyVangNghiDao.danhSachXinNghiDuyet();
	}
	
	public  void create(ThongKeDonXinPhep thongKeDonXinPhep) {
		quanLyVangNghiDao.create(thongKeDonXinPhep);
		
	}
	
	public List<LyDoXinNghi> loadAllLyDo() {
		return this.quanLyVangNghiDao.loadAllLyDo();
	}

	public List<TrangThai> loadAllTrangThai() {
		return this.quanLyVangNghiDao.loadAllTrangThai();
	}


	public List<HoSoNhanVien> loadAllHoSo() {
		return this.quanLyVangNghiDao.loadAllHoSo();
	}

	
	public List<ThongKeDonXinPhep> danhSachXinNghiTuChoi() {
		return this.quanLyVangNghiDao.danhSachXinNghiTuChoi();
	}
	
	public void createWait(ThongKeDonXinPhep thongKeDonXinPhep) {
		quanLyVangNghiDao.createWait(thongKeDonXinPhep);
		
	}

	public void createBrowse(ThongKeDonXinPhep thongKeDonXinPhep) {
		quanLyVangNghiDao.createBrowse(thongKeDonXinPhep);
		
	}

	public void createfeedback(ThongKeDonXinPhep thongKeDonXinPhep) {
		quanLyVangNghiDao.createfeedback(thongKeDonXinPhep);
		
	}

	public ThongKeDonXinPhep findById(int id) {
		return this.quanLyVangNghiDao.findById(id);
	}

	public void delete(int id) {
		quanLyVangNghiDao.delete(id);
		
	}

	public void updateNhap(ThongKeDonXinPhep thongKeDonXinPhep) {
		quanLyVangNghiDao.updateNhap(thongKeDonXinPhep);
		
	}
	public long totalRecords() {
		
		return this.quanLyVangNghiDao.totalRecords();
	}

	public List<ThongKeDonXinPhep> danhSachXinNghiNhap(int page) {
		return this.quanLyVangNghiDao.danhSachXinNghiNhap(page);
	}
	
	
}
