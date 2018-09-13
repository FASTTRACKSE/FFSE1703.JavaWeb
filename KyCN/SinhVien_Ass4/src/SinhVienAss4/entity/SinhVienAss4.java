package SinhVienAss4.entity;

import org.springframework.stereotype.Component;

@Component
public class SinhVienAss4 {
public String hoTen,email;

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public SinhVienAss4(String hoTen, String email) {
	super();
	this.hoTen = hoTen;
	this.email = email;
}

public String getHoTen() {
	return hoTen;
}

public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public SinhVienAss4(String hoTen) {
	this.hoTen = hoTen;
}
public String thongTinSinhVien() {
	String st = " - "+hoTen+" - "+email;

	return st;
}

}
