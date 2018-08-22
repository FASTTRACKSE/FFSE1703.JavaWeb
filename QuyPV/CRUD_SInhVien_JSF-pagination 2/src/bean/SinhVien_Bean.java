package bean;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;

@ManagedBean(name= "sinhVien_Bean")
@RequestScoped
public class SinhVien_Bean {

	private String maSv, hoTen, namSinh, queQuan, gioiTinh, email, dienThoai, maLop;
	
	public SinhVien_Bean() {
		//		
	}
	
	public SinhVien_Bean(String maSv, String hoTen, String namSinh, String queQuan, String gioiTinh, String email,
			String dienThoai, String maLop) {
		this.maSv = maSv;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.queQuan = queQuan;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.dienThoai = dienThoai;
		this.maLop = maLop;
	}

	
	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSV) {
		this.maSv = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

}
