package entity;

import org.springframework.stereotype.Component;

@Component
public class GiangVien {
	public String hoTen, email;

	public GiangVien() {
		super();
	}

	public GiangVien(String hoTen, String email) {
		super();
		this.hoTen = hoTen;
		this.email = email;
	}

	public String thongTinGiangVien() {
		return hoTen + " - " + email;

	}
}
