package entity;

import org.springframework.stereotype.Component;

@Component
public class GiangVien {
	private String tenGiangVien;
	public GiangVien() {
		
	}
	public GiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}
	public String getTenGiangVien() {
		return tenGiangVien;
	}
	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}
	public String giangVien() {
		return tenGiangVien;
	}
}
