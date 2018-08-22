package beans;

import org.hibernate.validator.constraints.NotEmpty;

public class Student {
	@NotEmpty(message= "Tên Không Được Để Trống !")
	private String tenSv;
	
	@NotEmpty(message= "Mã Sinh Vien Không Được Để Trống !")
	private String maSv;
	
	@NotEmpty(message = "Nam Sinh Không Được Để Trống !")
	private String namSinh;
	
	@NotEmpty(message = "Email Không Được Để Trống !")
	private String email;
	
	@NotEmpty(message = "Địa Chỉ Không Được Để Trống !")
	private String diaChi;
	
	@NotEmpty(message = "Lớp Học Không Được Để Trống !")
	private String lopHoc;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
