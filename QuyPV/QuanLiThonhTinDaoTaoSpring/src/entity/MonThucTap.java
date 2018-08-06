package entity;

public class MonThucTap implements MonHoc {
	private String noiThucTap;
	private GiangVien giangVienPhuTrach;
	
	public MonThucTap() {
		// 
	}
	
	public MonThucTap(String noiThucTap, GiangVien giangVienPhuTrach) {
		this.noiThucTap = noiThucTap;
		this.giangVienPhuTrach = giangVienPhuTrach;
	}
	
	@Override
	public String monHoc() {
		return "+" +noiThucTap + "\n \t " + "Giảng viên phụ trách: " + giangVienPhuTrach.giangVien();
	}

}
