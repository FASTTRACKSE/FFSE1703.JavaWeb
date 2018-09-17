package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HopDongTT;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

public interface HopDongServiceTT {
	
	public List<HopDongTT> getAllHopDong();

	public List<HopDongTT> getHopDongByPhongBan(String maPhongBan);

	public void addHopDong(HopDongTT tt);

	public void updateHopDong(HopDongTT tt);

	public String getAutoId();

	public String getRecordsTotal(String maPhongBan);

	public String getRecordsFiltered(String sql);

	public String getSQL(HttpServletRequest request, String maPhongBan);

	public List<HopDongTT> getAllHopDong(int iDisplayStart, int iDisplayLength, String sql);

	public String toJson(HopDongTT hd);

	public Object findAllForPaging(int startPosition, int recordsPerPage);

	public HoSoNhanVien getHoSoNhanVienById(int maNhanVien);
}
