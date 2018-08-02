package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonMysql implements MonHoc {

	public String monHoc() {

		return "Hôm nay học môn Mysql nha :";
	}

	public String giangVien() {

		return "Giảng viên Thắng dạy";
	}

}
