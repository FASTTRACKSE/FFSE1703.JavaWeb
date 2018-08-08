package entity;

import org.springframework.stereotype.Component;

@Component
public class Mentor implements GiangVien {
	public String hoTen, email;

	public Mentor() {
		super();
	}

	public Mentor(String hoTen, String email) {
		super();
		this.hoTen = hoTen;
		this.email = email;
	}

	@Override
	public String thongTinGiangVien() {
		return "Mentor: " + hoTen + " - " + email + "\n";
	}

}
