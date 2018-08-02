package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonHTML5 implements MonHoc{


	public String monHoc() {
		return "Hôm nay học môn HTML5 nha  :";
	}
	public String giangVien() {
		return "Giảng viên Thủy dạy";
	}
	

}
