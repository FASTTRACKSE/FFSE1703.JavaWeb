package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HopDongTT;

public interface QuanLyHopDongDaoTT {
	
	public String getRecordsTotal(String maPhongBan);

	public String getRecordsFiltered(String sql);

	public List<HopDongTT> getAllHopDong(int iDisplayStart, int iDisplayLength, String sql);

	public List<HopDongTT> getAllHopDong();

	public List<HopDongTT> getHopDongByPhongBan(String maPhongBan);

	public void addHopDong(HopDongTT tt);

	public void updateHopDong(HopDongTT tt);

	public String getAutoId();
	
	public HopDongTT findByMaHopDong(int maHopDong);
		
	
}
