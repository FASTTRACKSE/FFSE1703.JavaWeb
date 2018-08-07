package bean;

import org.springframework.stereotype.Component;

@Component
public class MonLy implements MonHoc {

	public String mangSachDiHoc() {
		return "Mang Sách Lý Đi Học";
	}
	public String giangVien() {
		return "Giang Viên 2"; 
	}
}
