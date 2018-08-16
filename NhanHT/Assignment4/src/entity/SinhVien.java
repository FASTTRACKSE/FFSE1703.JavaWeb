package entity;

import org.springframework.stereotype.Component;

@Component
public class SinhVien {
	private String hoTen,email,diaChi,dienThoai;
	public SinhVien() {
		super();
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public SinhVien(String hoTen, String email, String diaChi, String dienThoai) {
		super();
		this.hoTen = hoTen;
		this.email = email;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
	}

}
