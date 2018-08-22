package fasttrackse.entity;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
public class Student {

    
	public int maSV;
	@NotEmpty(message= "Nhập họ tên sinh viên")
	public String tenSV;
	@NotEmpty(message= "Nhập tuổi sinh viên")
	public String tuoiSV;
	@NotEmpty(message= "Nhập email của sinh viên")
	public String email;
	@NotEmpty(message= "Nhập địa chỉ sinh viên")
	public String diaChi;
	@NotEmpty(message= "Nhập lớp học")
	public String lop;
	public String avatar;
	public Student() {
		
	}
	public Student(int maSV) {
		super();
		this.maSV = maSV;
	}
	public Student(String tenSV, String tuoiSV, String email, String diaChi, String lop,String avatar) {
		this.tenSV = tenSV;
		this.tuoiSV = tuoiSV;
		this.email = email;
		this.diaChi = diaChi;
		this.lop = lop;
		this.avatar = avatar;
	}

	public Student(int maSV,String tenSV, String tuoiSV, String email, String diaChi, String lop, String avatar) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.tuoiSV = tuoiSV;
		this.email = email;
		this.diaChi = diaChi;
		this.lop = lop;
		this.avatar = avatar;
	}

	


	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
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
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
}

