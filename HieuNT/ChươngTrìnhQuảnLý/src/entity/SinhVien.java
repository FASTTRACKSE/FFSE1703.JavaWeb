package entity;

import org.springframework.stereotype.Component;

@Component

public class SinhVien {

	public String hoTen;

	public SinhVien() {
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public SinhVien(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String thongTin() {
		String st = " - "+hoTen+" - ";
//		 st += "Email: "+email+"\n";
//		 st += "Địa chỉ: "+diaChi+"\n";
//		 st += "Số điện thoại: "+sdt+"\n";
		return st;
	}
}
