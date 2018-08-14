package entity;

import org.springframework.stereotype.Component;

@Component
public class MonTiengAnh implements MonHoc {
	public String tenMonHoc;
	public String level;
	private GiangVien tenGV;
	private GiangVien troGiang;
	
	
	public String getTenMonHoc() {
		return tenMonHoc;
	}


	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public GiangVien getTenGV() {
		return tenGV;
	}


	public void setTenGV(GiangVien tenGV) {
		this.tenGV = tenGV;
	}


	public GiangVien getTroGiang() {
		return troGiang;
	}


	public void setTroGiang(GiangVien troGiang) {
		this.troGiang = troGiang;
	}


	public String thongTinMonHoc() {
		String kq= "\n +" + tenMonHoc;
		kq+= "\n   - Trình độ:" + level+ "\n - Giảng Viên:"+ tenGV.getGiangVien()+
				"\n -  Trợ Giảng:"+ troGiang.getGiangVien();
		return kq;
	}

}
