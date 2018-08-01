package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonLy implements MonHoc {
	public String mangSachDiHoc() {
		return "Mang sách Lý đi học ";
	}
	public String giangVien() {
		return "Thầy Nhân dạy";
	}
}
