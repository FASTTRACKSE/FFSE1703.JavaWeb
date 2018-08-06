package bean;

import org.springframework.stereotype.Component;

@Component
public class MonToan implements MonHoc {

	public String mangSachDiHoc() {
		return "Mang Sách Toán Đi Học";
	}
	public String giangVien() {
		return "Giang Viên 3"; 
	}
}
