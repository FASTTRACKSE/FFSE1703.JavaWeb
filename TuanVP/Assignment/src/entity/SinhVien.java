package entity;

import org.springframework.stereotype.Component;

@Component
public class SinhVien {
	public String hoTen;

	public SinhVien() {
		super();
	}

	public SinhVien(String hoTen) {
		super();
		this.hoTen = hoTen;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
}
