package entity;

import org.springframework.stereotype.Component;

@Component
public class TroGiang implements GiangVien {

	public String hoTen, email;

	public TroGiang() {
		super();
	}

	public TroGiang(String hoTen, String email) {
		super();
		this.hoTen = hoTen;
		this.email = email;
	}

	@Override
	public String thongTinGiangVien() {
		return"Trợ giảng: " + hoTen + " - " + email + "\n";
	}

}
