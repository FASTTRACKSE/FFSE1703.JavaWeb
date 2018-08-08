package fasttrackse.entity;

public class GiangVien {
	String tenGiangVien;
	String email;
	public GiangVien() {
		
	}
	public GiangVien(String tenGiangVien, String email) {
		this.tenGiangVien = tenGiangVien;
		this.email = email;
	}
	public String getGiangVien() {
		String result = tenGiangVien + email;
		return result;
	}

}
