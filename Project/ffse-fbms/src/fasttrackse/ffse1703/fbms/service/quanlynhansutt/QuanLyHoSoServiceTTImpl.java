package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.QuanLyHoSoDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;

public class QuanLyHoSoServiceTTImpl implements QuanLyHoSoServiceTT {

	@Autowired
	private QuanLyHoSoDaoTT quanLyHoSoDaoTT;

	public List<HoSoNhanVienTT> getAllHoSo() {
		// TODO Auto-generated method stub
		return this.quanLyHoSoDaoTT.getAllHoSo();
	}

	public List<HoSoNhanVienTT> getAllHoSo(int iDisplayStart, int iDisplayLength, String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public HoSoNhanVienTT getHoSoNhanVienById(int maNhanVien) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRecordsTotal(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRecordsFiltered(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSQL(HttpServletRequest request, String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HoSoNhanVienTT> getHoSoByPhongBan(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addHoSoNhanVien(HoSoNhanVienTT hsnv) {
		// TODO Auto-generated method stub

	}

	public void updateHoSoNhanVien(HoSoNhanVienTT hsnv) {
		// TODO Auto-generated method stub

	}

	public void deleteHoSoNhanVien(int maNhanVien) {
		// TODO Auto-generated method stub

	}

}
