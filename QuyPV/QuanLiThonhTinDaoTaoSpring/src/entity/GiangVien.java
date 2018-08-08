package entity;

public class GiangVien {
	private String tenGiangVien;
	private String email;
	
	public GiangVien() {
		//
	}
	
	public GiangVien(String tenGiangVien, String email) {
		this.tenGiangVien = tenGiangVien;
		this.email = email;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String giangVien() {
		return tenGiangVien + " - " + email;
	}
}
