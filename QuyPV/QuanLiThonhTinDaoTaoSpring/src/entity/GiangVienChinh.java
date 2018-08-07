package entity;

public class GiangVienChinh implements GiangVien {
	private String hoTen;
	private String email;
	
	public GiangVienChinh() {
		//
	}
	
	public GiangVienChinh(String hoTen, String email) {
		this.hoTen = hoTen;
		this.email = email;
	}



	@Override
	public String giangVien() {
		return "Giảng viên chính:  " + hoTen + " email: " + email;
	}

}
