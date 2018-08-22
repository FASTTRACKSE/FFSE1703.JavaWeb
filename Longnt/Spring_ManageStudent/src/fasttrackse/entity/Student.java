package fasttrackse.entity;

import org.springframework.lang.NonNull;

public class Student {
	
	public String maSV;
	public String tenSV;
	public String tuoiSV;
	public String email;
	public String diaChi;
	public String lop;
	
	public Student() {
		
	}
	public Student(String maSV) {
		super();
		this.maSV = maSV;
	}
	public Student(String tenSV, String tuoiSV, String email, String diaChi, String lop) {
		this.tenSV = tenSV;
		this.tuoiSV = tuoiSV;
		this.email = email;
		this.diaChi = diaChi;
		this.lop = lop;
	}

	public Student(String maSV,String tenSV, String tuoiSV, String email, String diaChi, String lop) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.tuoiSV = tuoiSV;
		this.email = email;
		this.diaChi = diaChi;
		this.lop = lop;
	}

	

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getTuoiSV() {
		return tuoiSV;
	}

	public void setTuoiSV(String tuoiSV) {
		this.tuoiSV = tuoiSV;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}
	
	
}

