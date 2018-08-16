package entity;

public class GiangVienPhuTrach implements GiangVien {
	private String tenGiangVien;
	private String email;
	
	public GiangVienPhuTrach() {
		// 
	}
	
	public GiangVienPhuTrach(String tenGiangVien, String email) {
		this.tenGiangVien = tenGiangVien;
		this.email = email;
	}
	
	@Override
	public String giangVien() {
		// TODO Auto-generated method stub
		return "Giảng viên phụ trách: " + tenGiangVien + " " + email;
	}

}
