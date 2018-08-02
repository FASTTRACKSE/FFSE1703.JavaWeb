package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonJavaCore implements MonHoc{

	
	public String monHoc() {
		return "Hôm nay học môn JavaCore nha :";
	}
	public String giangVien() {
		return "Giáo sư Thành dạy ";
	}

}
