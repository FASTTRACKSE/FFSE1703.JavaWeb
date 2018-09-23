package fasttrackse.ffse1703.fbms.service.qlvn;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlvn.NgayNghi;

public interface QuanLyNgayNghiService {
public List<NgayNghi> danhSachNgayNghi();
    
	public NgayNghi findById(int id);
	
	public void delete(int id);
	
}
