package entity;

import org.springframework.stereotype.Component;

@Component
public class MonCongNge implements MonHoc {
	private String tenMonCongNghe;
	private GiangVien giangVienChinh;
	@Override
	public String monHoc() {
		// TODO Auto-generated method stub
		return "+" + tenMonCongNghe + "\n \t " 
		+ "Giảng viên chính: " + giangVienChinh.giangVien();
}
}
