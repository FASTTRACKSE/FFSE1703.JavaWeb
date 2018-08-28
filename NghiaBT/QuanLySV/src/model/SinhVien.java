package model;

public class SinhVien {

	protected String maSV;
	protected String ten;
	protected String tuoi;
	protected String lop;
	protected String diaChi;
	protected String gioiTinh;
	
	public SinhVien() {
	}
	public SinhVien(String maSV, String ten, String tuoi, String lop, String diaChi, String gioiTinh) {
		this.maSV = maSV;
		this.ten = ten;
		this.tuoi = tuoi;
		this.lop = lop;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
	}
		
	

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
}
