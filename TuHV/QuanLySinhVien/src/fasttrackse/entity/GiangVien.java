package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class GiangVien {
	public String hoTen, email, sdt;

	public GiangVien() {
		super();
	}

	public GiangVien(String hoTen, String email, String sdt) {
		super();
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
	}

	public String thongTinGiangVien() {
		return hoTen + " - " + email + "SĐT :" + sdt;

	}
}