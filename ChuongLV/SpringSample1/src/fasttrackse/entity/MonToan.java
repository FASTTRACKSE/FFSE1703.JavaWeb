package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonToan implements MonHoc {
	public String mangSachDiHoc() {
		return "mang sách TOÁN đi học!";
	}

	@Override
	public String tenGiangVien() {
		// TODO Auto-generated method stub
		return "do thầy T dạy!";
	}

	
}