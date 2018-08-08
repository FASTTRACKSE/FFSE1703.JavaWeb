package entity;

import org.springframework.stereotype.Component;

@Component
public class GiangVienFE implements GiangVien {
	public String giangVien;

	public GiangVienFE() {
	}

	public GiangVienFE(String giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String giangVienDay() {
		return giangVien +" dạy";
	}

}
