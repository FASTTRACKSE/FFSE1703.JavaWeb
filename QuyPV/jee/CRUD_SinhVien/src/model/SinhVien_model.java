package model;

public class SinhVien_model {
	private String maSV, hoTen, tuoi, queQuan, gioiTinh, maLop;
	private double diemLp1, diemLp2;
	public SinhVien_model(String maSv, String hoTen, String tuoi, String queQuan, String gioiTinh, String maLop, double diemLp1, double diemLp2) {
		this.maSV = maSv;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.queQuan = queQuan;
		this.gioiTinh = gioiTinh;
		this.maLop = maLop;
		this.diemLp1 = diemLp1;
		this.diemLp2 = diemLp2;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getTuoi() {
		return tuoi;
	}
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
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
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public double getDiemLp1() {
		return diemLp1;
	}
	public void setDiemLp1(double diemLp1) {
		this.diemLp1 = diemLp1;
	}
	public double getDiemLp2() {
		return diemLp2;
	}
	public void setDiemLp2(double diemLp2) {
		this.diemLp2 = diemLp2;
	}
	
	public double diemTrungBinh() {
		return (diemLp1 + diemLp2) / 2;
	}
	
	public String xepLoai() {
		if(diemTrungBinh() >= 8.0) {
			return "Giỏi";
		} else if(diemTrungBinh() < 8.0 && diemTrungBinh() >= 6.5) {
			return "Khá";
		} else if(diemTrungBinh() < 6.5 && diemTrungBinh() >= 5.0 ) {
			return "Trung bình";
		} else {
			return "Yếu";
		}
	}
	
	
}
