package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonJavaWeb implements MonHoc{


	public String monHoc() {
	return "Hôm nay học môn JavaWeb nha :";
	}
	public String giangVien() {
		return "Giảng viên Lâm dạy ";
		}

}
