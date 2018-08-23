package fasttrackse.entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MonCongNghe implements MonHoc{
	private GiangVien tenMonHoc;
	private GiangVien giangVienChinh;
	private GiangVien troGiang;
	private GiangVien mentor;
	public MonCongNghe() {
	 
	}

public MonCongNghe(GiangVien giangVienChinh, GiangVien troGiang, GiangVien mentor,GiangVien tenMonHoc) {
	super();
	this.giangVienChinh = giangVienChinh;
	this.troGiang = troGiang;
	this.mentor = mentor;
	this.tenMonHoc = tenMonHoc;
}

public GiangVien getGiangVienChinh() {
	return giangVienChinh;
}


public GiangVien getTroGiang() {
	return troGiang;
}

public void setTroGiang(GiangVien troGiang) {
	this.troGiang = troGiang;
}

public GiangVien getMentor() {
	return mentor;
}

public void setMentor(GiangVien mentor) {
	this.mentor = mentor;
}


public void setGiangVienChinh(GiangVien giangVienChinh) {
	this.giangVienChinh = giangVienChinh;
}


public GiangVien getTenMonHoc() {
	return tenMonHoc;
}

public void setTenMonHoc(GiangVien tenMonHoc) {
	this.tenMonHoc = tenMonHoc;
}

@Override
public String getMonHoc() {
	String result = " Môn Công nghệ: "+ "\n"   ;
	result +=  tenMonHoc.getGiangVien() + "\n";
	result += "Giảng viên chính: "+ giangVienChinh.getGiangVien()+ "\n";
	result += "Trợ giảng: "+ troGiang.getGiangVien()+ "\n";
	result += "Mentor: "+ mentor.getGiangVien();
	return result;
}
}
