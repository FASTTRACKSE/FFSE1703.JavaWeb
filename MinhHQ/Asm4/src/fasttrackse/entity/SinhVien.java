package fasttrackse.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SinhVien {
	public String hoTen;
	public String email;
	public String sdt;
	
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
	
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public SinhVien(String hoTen, String email, String sdt) {
		this.email = email;
		this.hoTen = hoTen;
		this.sdt = sdt;
	}
	
	public String ttSinhVien() {
		String st = " - "+hoTen+" - "+email+" - "+sdt;
		return st;
	}
}
