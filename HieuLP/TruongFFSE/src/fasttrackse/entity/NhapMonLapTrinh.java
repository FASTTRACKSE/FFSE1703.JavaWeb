package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class NhapMonLapTrinh implements MonHoc {
	public String getMonHoc() {
		return "Nhập môn lập trình _ Giảng viên : Thầy Thành";
	}
}
