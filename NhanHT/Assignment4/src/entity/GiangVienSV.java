package entity;

public class GiangVienSV   {
	private String hoTen,email;
	
	public GiangVienSV(String hoTen, String email) {
		super();
		this.hoTen = hoTen;
		this.email = email;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String thongTinGiangVien() {
		String st = hoTen+ " "+ email;
		return st;
	}


}
