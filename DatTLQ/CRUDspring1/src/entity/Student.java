package entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Student {
	private String id;
	@NotEmpty(message ="Họ tên không được để trống")
	private String tenSV;
	@NotEmpty(message ="Năm sinh không được để trống")
	private String namSinh;
	@NotEmpty(message="Email không được để trống")
	@Email(message="Email không đúng định dạng")
	private String email;
	@NotEmpty(message="Vui lòng nhập địa chỉ")
	private String diaChi;
	@NotEmpty(message="Vui lòng chọn lớp")
	private String lopHoc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Student(String id, String tenSV, String namSinh, String email, String diaChi, String lopHoc) {
		super();
		this.id = id;
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
	}

	public Student() {

	}
}
