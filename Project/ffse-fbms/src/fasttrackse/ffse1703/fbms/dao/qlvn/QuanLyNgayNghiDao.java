package fasttrackse.ffse1703.fbms.dao.qlvn;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlvn.NgayNghi;

public interface QuanLyNgayNghiDao {
	public List<NgayNghi> danhSachNgayNghi();
    
	public NgayNghi findById(int id);
	
	public void delete(int id);


	
	
}
