package model.entity;

public class SinhVien {
	public String maSV, tenSV, namSinh, email, diaChi, lopHoc ;

	public SinhVien() {
		super();
	}
	
	public SinhVien(String maSV) {
		super();
		this.maSV = maSV;
	}
	
	public SinhVien(String maSV, String tenSV, String namSinh, String email, String diaChi, String lopHoc) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
	}

	public SinhVien(String tenSV, String namSinh, String email, String diaChi, String lopHoc) {
		super();
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
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

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
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

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}
	
}
