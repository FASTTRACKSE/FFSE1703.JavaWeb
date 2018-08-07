package vn.model;

import org.springframework.stereotype.Component;

@Component
public class JavaCore implements MonHoc {
	public String getTenMonHoc() {
		return "Mang Sách Java Core Đi Học";
	}
	@Override
	public String getGiangVien() {
		// TODO Auto-generated method stub
		return "Thầy Thành";
	}
	
}
