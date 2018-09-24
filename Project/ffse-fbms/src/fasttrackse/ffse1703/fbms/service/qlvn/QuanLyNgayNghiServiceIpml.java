package fasttrackse.ffse1703.fbms.service.qlvn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.qlvn.QuanLyNgayNghiDao;
import fasttrackse.ffse1703.fbms.entity.qlvn.NgayNghi;
@Service
@Transactional
public class QuanLyNgayNghiServiceIpml implements QuanLyNgayNghiService {

	@Autowired
	private QuanLyNgayNghiDao quanLyNgayNghiDao;


	public void setQuanLyNgayNghiDao(QuanLyNgayNghiDao quanLyNgayNghiDao) {
		this.quanLyNgayNghiDao = quanLyNgayNghiDao;
	}

	public List<NgayNghi> danhSachNgayNghi() {
		return this.quanLyNgayNghiDao.danhSachNgayNghi();
	}

	public NgayNghi findById(int id) {
		return this.quanLyNgayNghiDao.findById(id);
	}

	public void delete(int id) {
		quanLyNgayNghiDao.delete(id);
		
	}

}
