package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.KhachHang;

public interface KhachHangService {
	public List<KhachHang> getAll();

	public KhachHang findById(String makh);

	public void add(KhachHang khachhang);

	public void update(KhachHang khachhang);

	public void delete(KhachHang khachhang);

	public List<KhachHang> findAllForPaging(int startPosition, int maxResult);

}
