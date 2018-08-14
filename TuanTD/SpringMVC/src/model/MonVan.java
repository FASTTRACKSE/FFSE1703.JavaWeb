package model;

import org.springframework.stereotype.Component;

@Component
public class MonVan implements MonHoc {
	public String mangSachDiHoc() {
		return "Mang Sách Văn Đi Học";
	}
	public String giangVien() {
		return "Thầy Thành";
	}
	
}