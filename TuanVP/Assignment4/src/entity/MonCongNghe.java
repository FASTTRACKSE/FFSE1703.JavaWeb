package entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MonCongNghe implements MonHoc {
	public String tenMonHoc;
	public GiangVien giangVienChinh;
	public GiangVien troGiang;
	public GiangVien mentor;

	public MonCongNghe() {
		super();
	}

	public MonCongNghe(String tenMonHoc, GiangVien giangVienChinh, GiangVien troGiang, GiangVien mentor) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;
		this.mentor = mentor;
	}

	@Override
	public String thongTinMonHoc() {
		String st = "  - Tên môn học: " + tenMonHoc + "\n";
		st += "   + Giảng viên chính: " + giangVienChinh.thongTinGiangVien() + "\n";
		st += "   + Trợ giảng: " + troGiang.thongTinGiangVien() + "\n";
		st += "   + Mentor:  " + mentor.thongTinGiangVien() + "\n";
		return st;
	}

}
