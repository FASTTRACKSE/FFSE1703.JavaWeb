package bean;

import org.springframework.stereotype.Component;

@Component
public class MonHoc implements MonHocSV{
	private String tenMonHoc;
	private GiangVien giangVien;
	
	public MonHoc() {
		super();
	}

	public MonHoc(String tenMonHoc,GiangVien giangVien) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVien = giangVien;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	@Override
	public String monHoc() {
		// TODO Auto-generated method stub
		return "Môn Học: "+tenMonHoc +" // "+" GV: "+ giangVien.giangVien();
	}
	
}
