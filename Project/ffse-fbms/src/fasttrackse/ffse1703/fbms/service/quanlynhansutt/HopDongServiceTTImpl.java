package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.QuanLyHopDongDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HopDongTT;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Service
public class HopDongServiceTTImpl implements HopDongServiceTT{
    @Autowired
    private QuanLyHopDongDaoTT quanLyHopDongDaoTT;
    
    
   
	@Override
	@Transactional
	public List<HopDongTT> getAllHopDong() {
		// TODO Auto-generated method stub
		return this.quanLyHopDongDaoTT.getAllHopDong();
	}

	@Override
	@Transactional
	public List<HopDongTT> getHopDongByPhongBan(String maPhongBan) {
		// TODO Auto-generated method stub
		return this.quanLyHopDongDaoTT.getHopDongByPhongBan(maPhongBan);
	}

	@Override
	public void addHopDong(HopDongTT tt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHopDong(HopDongTT tt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAutoId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRecordsTotal(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRecordsFiltered(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSQL(HttpServletRequest request, String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HopDongTT> getAllHopDong(int iDisplayStart, int iDisplayLength, String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toJson(HopDongTT hd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findAllForPaging(int startPosition, int recordsPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoSoNhanVien getHoSoNhanVienById(int maNhanVien) {
		// TODO Auto-generated method stub
		return null;
	}

	public HopDongServiceTTImpl() {
		// TODO Auto-generated constructor stub
	}

}
