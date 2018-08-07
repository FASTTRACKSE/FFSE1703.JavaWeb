package entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MonCongNghe implements MonHoc {
	public String tenMonHoc;
	public GiangVienChinh giangVienChinh;
	public TroGiang troGiang;
	public Mentor mentor;

	public MonCongNghe() {
		super();
	}

	public MonCongNghe(String tenMonHoc, GiangVienChinh giangVienChinh, TroGiang troGiang, Mentor mentor) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;
		this.mentor = mentor;
	}

	@Override
	public String thongTinMonHoc() {
		String st = "  - Tên môn học: " + tenMonHoc + "\n";
		st += "   + " + giangVienChinh.thongTinGiangVien();
		st += "   + " + troGiang.thongTinGiangVien();
		st += "   + " + mentor.thongTinGiangVien();
		return st;
	}

}
