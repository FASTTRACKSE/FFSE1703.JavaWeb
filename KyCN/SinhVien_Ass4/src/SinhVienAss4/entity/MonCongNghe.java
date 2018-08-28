package SinhVienAss4.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MonCongNghe implements MonHoc {
	public String tenMonHoc;
	public GiangVien giangVienChinh;
	public GiangVien troGiang;
	
	public MonCongNghe(String tenMonHoc, GiangVien giangVienChinh, GiangVien troGiang) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;

	}
	
	@Override
	public String monHoc() {
		String st = "  - Tên môn h�?c: " + tenMonHoc + "\n";
		st += "   + Giảng viên chính: " + giangVienChinh.thongTinGiangVien() + "\n";
		st += "   + Trợ giảng: " + troGiang.thongTinGiangVien() + "\n";
		return st;
	}



}
