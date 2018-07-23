package sinhvien.service;

public class SinhVien {
	private String  hoTen, gioiTinh, email, diaChi, lop, sdt, namSinh;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public SinhVien(){
		
	}
	
	public SinhVien(String hoTen, String gioiTinh, String email, String diaChi, String lop, String sdt, String namSinh){
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.diaChi = diaChi;
		this.lop = lop;
		this.sdt = sdt;
		this.namSinh =namSinh;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	

}
