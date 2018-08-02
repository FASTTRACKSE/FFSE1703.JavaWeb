package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class SinhVien {
	private String hoTen;

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public SinhVien() {
		
	}
	public SinhVien(String hoten) {
		this.hoTen = hoten;
	}
}
