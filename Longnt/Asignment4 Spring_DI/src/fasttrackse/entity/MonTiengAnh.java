package fasttrackse.entity;
import org.springframework.stereotype.Component;

@Component
public class MonTiengAnh implements MonHoc {
	private GiangVien giangVienChinh;
	private GiangVien troGiang;
	public MonTiengAnh() {
	  
	}
	
public MonTiengAnh(GiangVien giangVienChinh, GiangVien troGiang) {
		super();
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;
	}


public GiangVien getGiangVienChinh() {
	return giangVienChinh;
}

public void setGiangVienChinh(GiangVien giangVienChinh) {
	this.giangVienChinh = giangVienChinh;
}

public GiangVien getTroGiang() {
	return troGiang;
}

public void setTroGiang(GiangVien troGiang) {
	this.troGiang = troGiang;
}

public String getMonHoc() {
	String result = " Môn tiếng anh "+"\n";
	result += "Giảng viên chính: "+ giangVienChinh.getGiangVien()+"\n";
	result += "Trợ giảng: "+ troGiang.getGiangVien();
	return result;
}
}
