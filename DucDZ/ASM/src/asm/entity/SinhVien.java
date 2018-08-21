package asm.entity;

public class SinhVien {
	String hoten;
	String email;
	String diachi;
	String sdt;
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public SinhVien() {
		
	}
	public SinhVien(String hoten, String email, String diachi, String sdt) {
		super();
		this.hoten = hoten;
		this.email = email;
		this.diachi = diachi;
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String thongtinSV() {
		String info = " - " + hoten + " - "+email;
		return info;
	}
}
