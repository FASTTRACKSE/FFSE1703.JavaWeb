package asm.entity;

public class GiangVien {
	public String hoTen, email;
	public GiangVien() {
		super();
	}
	public GiangVien(String hoTen, String email) {
		this.hoTen=hoTen;
		this.email=email;
	}
	public String thongtinGiangVien() {
		return hoTen+" - "+email;
	}
}
