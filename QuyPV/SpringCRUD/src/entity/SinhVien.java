package entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sun.istack.internal.NotNull;

@Component
public class SinhVien {
	private String hinhAnh;
	
	@NotEmpty(message= "Nhập mã sinh viên")
	private String maSv;
	
	@NotEmpty(message= "Nhập họ tên sinh viên")
	private String hoTen;
	
	@NotEmpty(message= "Nhập quê quán sinh viên")
	private String queQuan;
	
	@Email(message= "Email phải nhập đúng dạng")
	@NotEmpty(message= "Nhập email sinh viên")
	private String email;
	
	private String maLop;
	
	@Min(value= 1900, message= "năm sinh phải lớn hơn 1900")
	private int namSinh;
	
	@NotNull
	private int dienThoai;
	
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public int getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(int dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	
}
