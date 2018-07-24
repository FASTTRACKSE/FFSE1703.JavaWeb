package bean;

public class SinhVien {
		private String hoDem;
		private String tenSv;
		private String maSv;
		private String ngaySinh;
		private String queQuan;
		private String gioiTinh;
		private double diemLP1, diemLP2;
	
	public SinhVien(){
		
	}
		
	public SinhVien(String hoDem, String tenSv, String maSv, String ngaySinh, String queQuan, String gioiTinh, double diemLP1, double diemLP2) {
		this.hoDem = hoDem;
		this.tenSv = tenSv;
		this.maSv = maSv;
		this.ngaySinh = ngaySinh;
		this.queQuan = queQuan;
		this.gioiTinh = gioiTinh;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
		}
	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
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

	public String getTenSv() {
		return tenSv;
	}

	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public double getDiemLP1() {
		return diemLP1;
	}

	public void setDiemLP1(double diemLP1) {
		this.diemLP1 = diemLP1;
	}

	public double getDiemLP2() {
		return diemLP2;
	}

	public void setDiemLP2(double diemLP2) {
		this.diemLP2 = diemLP2;
	}
	public double getDTB() {
		
		return (diemLP1+diemLP2)/2;
	}
	public String getXL() {
		 if ((diemLP1+diemLP2)/2 >= 8.5) {
             return  "Giỏi";
		 
		 } else if (((diemLP1+diemLP2)/2 >= 7) && ((diemLP1+diemLP2)/2 < 8.5)) {
			 return "Khá";
		
		 } else if (((diemLP1+diemLP2)/2 >= 5.5) && ((diemLP1+diemLP2)/2 < 7)) {
			 return "Loại TB";
   
		 } else if (((diemLP1+diemLP2)/2 > 4) && ((diemLP1+diemLP2)/2 < 5.5)) {
			 return  "Yếu";
			 
		 } else {
			 return  "Kém";
    }
	}
}
	