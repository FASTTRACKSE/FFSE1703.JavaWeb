package bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SinhVien {
	private int id;
	@NotEmpty(message= "Nhập mã sinh viên")
	private String maSv;
	@NotEmpty(message= "Nhập tên sinh viên")
	@Size(min = 2, max = 20, message= "Nhập ít nhất 2 và nhiều nhất 20 ký tự")
	private String tenSv;
	@NotEmpty(message= "Nhập tên năm sinh")
	private String namSinh;
	@NotEmpty(message= "Nhập email")
	@Email(message= "Nhập sai định dạng email")
	private String email;
	@NotEmpty(message= "Nhập địa chỉ")
	private String diaChi;
	@NotEmpty(message= "Nhập lớp")
	private String lop;
	public SinhVien() {
		
	}
	public SinhVien(String maSv, String tenSv, String namSinh, String email, String diaChi, String lop, int id) {
		this.maSv = maSv;
		this.tenSv = tenSv;
		this.namSinh = namSinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lop = lop;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public String getTenSv() {
		return tenSv;
	}
	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
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
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
}
