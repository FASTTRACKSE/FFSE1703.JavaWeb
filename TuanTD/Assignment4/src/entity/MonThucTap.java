package entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MonThucTap implements MonHoc {
	public String noiThucTap;
	public GiangVienChinh giangVienPhuTrach;

	public MonThucTap() {
		super();
	}

	public MonThucTap(String noiThucTap, GiangVienChinh giangVienPhuTrach) {
		super();
		this.noiThucTap = noiThucTap;
		this.giangVienPhuTrach = giangVienPhuTrach;
	}

	public String getNoiThucTap() {
		return noiThucTap;
	}

	public void setNoiThucTap(String noiThucTap) {
		this.noiThucTap = noiThucTap;
	}

	public GiangVienChinh getGiangVienPhuTrach() {
		return giangVienPhuTrach;
	}

	public void setGiangVienPhuTrach(GiangVienChinh giangVienPhuTrach) {
		this.giangVienPhuTrach = giangVienPhuTrach;
	}

	@Override
	public String thongTinMonHoc() {
		String st = "  - Nơi thực tập: "+noiThucTap+"\n";
		st+="   Giảng viên chính: "+giangVienPhuTrach.hoTen+" - "+giangVienPhuTrach.email+"\n";
		return st;
	}

}
