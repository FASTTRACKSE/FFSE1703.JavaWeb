package entity;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SinhVien {
	private String hoTen, email, diaChi;
	private String dienThoai;
	
	public SinhVien() {
		//
	}
	
	public SinhVien(String hoTen, String email, String diaChi, String dienThoai) {
		this.hoTen = hoTen;
		this.email = email;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
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
	
	public String danhSachSinhVien() {
		return hoTen + " " + email + " " + diaChi + " " + dienThoai;
	}
	
	
}
