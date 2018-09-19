package fasttrackse.ffse1703.fbms.dao.QuanLyDuAn;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.KhachHang;

public interface KhachHangDao {
	public List<KhachHang> getAll();

	public KhachHang findById(String maKH);

	public void delete(KhachHang khachhang);

	public void update(KhachHang khachhang);

	public void create(KhachHang khachhang);
	
	public List<KhachHang> findAllForPaging(int startPosition,int maxResult);

}
