package bean;

import org.springframework.stereotype.Component;

@Component("monLy")
public class MonLy implements MonHoc {
	public String mangSachDiHoc() {
		return "Mang sách Lý đi học";
	}
	public String giangVien() {
		return "  - Thầy Nam";
	}
}
