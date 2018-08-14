package entity;

public class Mentor implements GiangVien {

	private String hoTen;
	private String email;
	
	public Mentor() {
		//
	}
	
	public Mentor(String hoTen, String email) {
		this.hoTen = hoTen;
		this.email = email;
	}
	
	@Override
	public String giangVien() {
		return "Mentor: " + hoTen + " email: " + email;
	}

}
