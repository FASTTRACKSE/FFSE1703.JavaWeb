package entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SinhVien {
	public String hoTen, email, diaChi, sdt;

	public SinhVien() {
		super();
	}

	public SinhVien(String hoTen, String email, String diaChi, String sdt) {
		super();
		this.hoTen = hoTen;
		this.email = email;
		this.diaChi = diaChi;
		this.sdt = sdt;
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

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String thongTinSinhVien() {
		String st = " - " + hoTen + " - " + email + " - " + sdt;
		return st;
	}
}
