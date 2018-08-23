package fasttrackse.entity;
import org.springframework.stereotype.Component;

@Component
public class MonThucTap implements MonHoc {
	private GiangVien tenMonHoc;
	private GiangVien giangVienPhuTrach;
	public MonThucTap() {
		 
	}	
public MonThucTap(GiangVien giangVienPhuTrach, GiangVien noiThucTap) {
		super();
		this.giangVienPhuTrach = giangVienPhuTrach;
		this.tenMonHoc = tenMonHoc;
	}
public GiangVien getGiangVienPhuTrach() {
	return giangVienPhuTrach;
}

public void setGiangVienPhuTrach(GiangVien giangVienPhuTrach) {
	this.giangVienPhuTrach = giangVienPhuTrach;
}


public GiangVien getTenMonHoc() {
	return tenMonHoc;
}
public void setTenMonHoc(GiangVien tenMonHoc) {
	this.tenMonHoc = tenMonHoc;
}
public String getMonHoc() {
	String result = " Môn thực tập:  " + tenMonHoc.getGiangVien() +" \n";
	result += "Giảng viên phụ trách: "+giangVienPhuTrach.getGiangVien() ;
	return result;
}
}
