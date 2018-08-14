package entity;

import org.springframework.stereotype.Component;

@Component
public class SinhVien {
	private String hoTen,email,diaChi,dienThoai;
	
	public SinhVien() {
		
	}
	public SinhVien(String hoTen, String email, String diaChi, String dienThoai) {
		super();
		this.hoTen = hoTen;
		this.email = email;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
	}
	public String getSinhVien() {
		return hoTen+" \n"
				+ "     + Email: "+email+""
			   +"\n     + Địa chỉ: " + diaChi
			   +"\n     + Sđt: " + dienThoai;
	}
}
