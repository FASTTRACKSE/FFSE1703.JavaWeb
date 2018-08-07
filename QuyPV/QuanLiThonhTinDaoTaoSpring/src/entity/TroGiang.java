package entity;

public class TroGiang implements GiangVien {
	private String hoTen;
	private String email;
	
	public TroGiang() {
		//
	}
	
	public TroGiang(String hoTen, String email) {
		this.hoTen = hoTen;
		this.email = email;
	}
	
	@Override
	public String giangVien() {
		return "Trợ giảng: " + hoTen + " email: " + email;
	}

}
