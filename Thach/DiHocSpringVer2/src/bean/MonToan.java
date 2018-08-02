package bean;

import org.springframework.stereotype.Component;

@Component("monToan")
public class MonToan implements MonHoc {
	public String mangSachDiHoc() {
		return "Mang sách Toán đi học";
	}
	public String giangVien() {
		return "  - Thầy Thành";
	}
}
