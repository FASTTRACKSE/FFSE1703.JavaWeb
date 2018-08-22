package fasttrackse.entity;

import org.springframework.stereotype.Component;
@Component
public class MonToan implements MonHoc {
	public String mangSachDiHoc() {
		return "Mang sÃ¡ch Math Ä‘i há»�c";
	}
	public String giaovien() {
		return "Của giảng viên Thành";
	}
}
