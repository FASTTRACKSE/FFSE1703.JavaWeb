package model.entity;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class SinhVien {
	@NotEmpty
	public String maSV;

	@NotEmpty
	public String tenSV;

	@DecimalMin(value = "1990")
	@NotEmpty
	public String namSinh;

	@NotEmpty
	@Email
	public String email;

	@NotEmpty
	public String diaChi;

	@NotEmpty
	public String lopHoc;

	public String avatar;

	public SinhVien() {
		super();
	}

	public SinhVien(String maSV) {
		super();
		this.maSV = maSV;
	}

	public SinhVien(String maSV, String tenSV, String namSinh, String email, String diaChi, String lopHoc,
			String avatar) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
		this.avatar = avatar;
	}

	public SinhVien(String tenSV, String namSinh, String email, String diaChi, String lopHoc, String avatar) {
		super();
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
		this.avatar = avatar;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
