package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class GiangVienEnglish implements MonHoc {

	@Override
	public String tenGiangVien() {
		return "Do cô Hồng dạy";
	}

	@Override
	public String mangSachDiHoc() {
		// TODO Auto-generated method stub
		return null;
	}

}