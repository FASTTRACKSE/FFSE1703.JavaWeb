package hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="quanlysinhvien2")
public class SinhVien {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ma_sv")
	@NotEmpty(message="Nhập mã sinh viên")
	private String maSv;
	
	@NotEmpty(message="Nhập Họ Tên sinh viên")
	private String ten;
	
	@Column(name="namsinh")
	@Min(value=1990,message="Năm sinh phải từ 1900->2018")
	@Max(value=2018,message="Năm sinh phải từ 1900->2018")
	@NotEmpty(message="Nhập năm sinh sinh viên")
	private String namSinh;
	
	@Email(message="Nhập đúng định dạng email !!")
	@NotEmpty(message="Nhập email sinh viên")
	private String email;
	
	@NotNull
	private String sdt;
	
	@Column(name="diachi")
	@NotEmpty(message="Nhập địa chỉ sinh viên")
	private String diaChi;
	
	private String lop;
	
	@Column(name="hinhanh")
	private String hinhAnh;
	

	public SinhVien() {
	}

	public SinhVien(int id, String maSv, String ten, String namSinh, String email, String sdt,
			String diaChi, String lop, String hinhAnh) {
		super();
		this.id = id;
		this.ten = maSv;
		this.ten = ten;
		this.namSinh = namSinh;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.lop = lop;
		this.hinhAnh = hinhAnh;
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

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
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

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
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

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
}
