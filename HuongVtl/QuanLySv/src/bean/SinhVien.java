package bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SinhVien {
		private String tenSv;
		private String maSv;
		private String ngaySinh;
		private double diemLP1, diemLP2;
	
	public SinhVien(){
		
	}
		
	public SinhVien(String tenSv, String maSv, String ngaySinh,  double diemLP1, double diemLP2) {
		this.tenSv = tenSv;
		this.maSv = maSv;
		this.ngaySinh = ngaySinh;
		this.diemLP1 = diemLP1;
		this.diemLP2 = diemLP2;
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
	