package FFSE;

public class ThucTap implements MonHoc{

	public String noiThucTap;
	public GiangVienChinh giangVienPhuTrach;

	public ThucTap() {
		super();
	}

	public ThucTap(String noiThucTap, GiangVienChinh giangVienPhuTrach) {
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
	public String getMonHoc() {
		String st = "  - Nơi thực tập: "+noiThucTap+"\n";
		st+="   Giảng viên chính: "+giangVienPhuTrach.hoTen+" - "+giangVienPhuTrach.email+"\n";
		return st;
	}


}
