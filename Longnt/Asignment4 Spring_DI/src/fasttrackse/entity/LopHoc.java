package fasttrackse.entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("Prototype")
public class LopHoc {
private String tenLop;
private DaoTaoDaiHan daoTaoDaiHan;
private DaoTaoNganHan daoTaoNganHan;
private SinhVien sinhVien;
public LopHoc() {
 
}

public LopHoc(String tenLop, DaoTaoDaiHan daoTaoDaiHan, DaoTaoNganHan daoTaoNganHan,SinhVien sinhVien) {
	super();
	this.tenLop = tenLop;
	this.daoTaoDaiHan = daoTaoDaiHan;
	this.daoTaoNganHan = daoTaoNganHan;
	this.sinhVien = sinhVien;
	
}


public String getTenLop() {
	return tenLop;
}

public void setTenLop(String tenLop) {
	this.tenLop = tenLop;
}

public DaoTaoDaiHan getDaoTaoDaiHan() {
	return daoTaoDaiHan;
}

public void setDaoTaoDaiHan(DaoTaoDaiHan daoTaoDaiHan) {
	this.daoTaoDaiHan = daoTaoDaiHan;
}

public DaoTaoNganHan getDaoTaoNganHan() {
	return daoTaoNganHan;
}

public void setDaoTaoNganHan(DaoTaoNganHan daoTaoNganHan) {
	this.daoTaoNganHan = daoTaoNganHan;
}

public SinhVien getSinhVien() {
	return sinhVien;
}

public void setSinhVien(SinhVien sinhVien) {
	this.sinhVien = sinhVien;
}

public String mangSachDiHoc() {
	String result = tenLop + "\n";
	result += "\n" + daoTaoDaiHan.getDaoTao();
	result += "\n" + daoTaoNganHan.getDaoTao();
	result += "Danh sách sinh Viên" + "\n";
	result += sinhVien.hoTen+ " " + sinhVien.diaChi + " " + sinhVien.email + " " + sinhVien.dienThoai  ;
	
	return result;
}
}

