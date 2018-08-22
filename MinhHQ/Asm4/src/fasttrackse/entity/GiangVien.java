package fasttrackse.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GiangVien {
	public String tenGV;
	public String email;
	
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public GiangVien(String hoTen, String email) {
		super();
		this.tenGV = hoTen;
		this.email = email;
	}

	public String thongTinGiangVien() {
		return tenGV + " - " + email;

	}
}
