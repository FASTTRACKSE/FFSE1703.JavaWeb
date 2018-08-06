package bean;

import org.springframework.stereotype.Component;

@Component
public class GiangVien implements GiangVienSV{
	private String tenGiangVien;
	
	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiangVien(String tenGiangVien) {
		super();
		this.tenGiangVien = tenGiangVien;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	@Override
	public String giangVien() {
		// TODO Auto-generated method stub
		return tenGiangVien;
	}

}
