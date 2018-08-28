package hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import com.sun.istack.internal.NotNull;

@Entity
@Table(name= "Sinh_vien")

public class SinhVien {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
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