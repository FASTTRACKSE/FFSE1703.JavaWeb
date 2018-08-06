package entity;

import java.util.ArrayList;
import java.util.List;

public class MonCongNghe implements MonHoc {
	private String tenMonCongNghe;
	private GiangVien giangVienChinh;
	private GiangVien mentor;
	
	public MonCongNghe() {
		// 
	}
	
	public MonCongNghe(String tenMonCongNghe, GiangVien giangVien, GiangVien mentor) {
		this.tenMonCongNghe = tenMonCongNghe;
		this.giangVienChinh = giangVien;
		this.mentor = mentor;
	}
	
	@Override
	public String monHoc() {
		return "+" + tenMonCongNghe + "\n \t " + giangVienChinh.giangVien() + "\n \t " + mentor.giangVien();
	}

}
