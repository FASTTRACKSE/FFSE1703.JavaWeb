package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonEnglish implements MonHoc {
	public String mangSachDiHoc() {
		return "mang sách ENGLISH đi học!";
	}

	@Override
	public String tenGiangVien() {
		// TODO Auto-generated method stub
		return "do thầy T dạy!";
	}

}