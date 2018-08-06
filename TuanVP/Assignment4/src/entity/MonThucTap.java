package entity;

import org.springframework.stereotype.Component;

@Component

public class MonThucTap implements MonHoc {
	public String noiThucTap;
	public GiangVien giangVienPhuTrach;

	public MonThucTap() {
		super();
	}

	public MonThucTap(String noiThucTap, GiangVien giangVienPhuTrach) {
		super();
		this.noiThucTap = noiThucTap;
		this.giangVienPhuTrach = giangVienPhuTrach;
	}


	@Override
	public String thongTinMonHoc() {
		String st = "  - Nơi thực tập: "+noiThucTap+"\n";
		st+="   + Giảng viên chính: "+giangVienPhuTrach.thongTinGiangVien()+"\n";
		return st;
	}

}
