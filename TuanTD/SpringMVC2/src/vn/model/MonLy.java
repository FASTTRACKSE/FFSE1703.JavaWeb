package vn.model;

import org.springframework.stereotype.Component;

@Component
public class MonLy implements MonHoc {
	public String getTenMonHoc() {
		return "Mang Sách Java Web Đi Học";
	}
	@Override
	public String getGiangVien() {
		// TODO Auto-generated method stub
		return "Thầy Lâm";
	}
}
