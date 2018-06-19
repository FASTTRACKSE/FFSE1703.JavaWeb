package Model;

public class QuanLiSinhVienModel {
	public int id;
	public String  hoDem, ten, ngaySinh, queQuan, gioiTinh, lop,xepLoai;
	public double lp0,lp1,diemTB;
	public QuanLiSinhVienModel(int id, String hoDem, String ten, String ngaySinh, String queQuan,
			String gioiTinh, String lop, double lp0, double lp1) {
		this.id = id;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.queQuan = queQuan;
		this.gioiTinh = gioiTinh;
		this.lop = lop;
		this.lp0 = lp0;
		this.lp1 = lp1;
	}

	public QuanLiSinhVienModel(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
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

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public double getLp0() {
		return lp0;
	}

	public void setLp0(double lp0) {
		this.lp0 = lp0;
	}

	public double getLp1() {
		return lp1;
	}

	public void setLp1(double lp1) {
		this.lp1 = lp1;
	}

	public double getDTB() {
		return (lp0 + lp1) / 2;
	}

	public String getXepLoai() {
		if (getDTB() >= 8.5 && getDTB() <= 10) {
			return xepLoai = "Giỏi";
		} else if (getDTB() >= 6.5 && getDTB() < 8.5) {
			return xepLoai = "khá";
		} else if (getDTB() < 6.5 && getDTB() >= 5) {
			return xepLoai = "Trung Bình";
		} else if (getDTB() < 5 && getDTB() > 0) {
			return xepLoai = "Yếu";
		} else {
			return xepLoai = "Chưa Đạt";
		}
	}
}
