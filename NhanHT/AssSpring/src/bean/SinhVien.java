package bean;

import org.springframework.stereotype.Component;

@Component
public class SinhVien {
	private String tenSv;
	
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(String tenSv) {
		super();
		this.tenSv = tenSv;
	}

	public String getTenSv() {
		return tenSv;
	}

	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}
	
}
