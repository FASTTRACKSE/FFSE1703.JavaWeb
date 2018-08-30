package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SinhVien")
public class Student {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "MaSv")
	private String maSv;
	
	@Column(name = "TenSv")
	private String tenSv;

	@Column(name = "NamSinh")
	private String namSinh;

	@Column(name = "Email")
	private String email;

	@Column(name = "DiaChi")
	private String diaChi;

	@Column(name = "LopHoc")
	private String lopHoc;

	public Student() {
		super();
	}

	public Student(String tenSv, String maSv, String namSinh, String email, String diaChi, String lopHoc) {
		super();
		this.tenSv = tenSv;
		this.maSv = maSv;
		this.namSinh = namSinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
	}

	public Student(int id, String tenSv, String maSv, String namSinh, String email, String diaChi, String lopHoc) {
		super();
		this.id = id;
		this.tenSv = tenSv;
		this.maSv = maSv;
		this.namSinh = namSinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
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

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}


}
