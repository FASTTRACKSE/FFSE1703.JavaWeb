package entity;

import org.springframework.stereotype.Component;

@Component
public class SinhVien {

	private String hoTen;

	
	public SinhVien() {
		//
	}

	public SinhVien(String hoTen) {
		super();
		this.hoTen = hoTen;
	}
	public String tenSV() {
		return  hoTen + ":";
	}
}
