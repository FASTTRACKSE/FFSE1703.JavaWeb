package entity;

import org.springframework.stereotype.Component;

@Component
public class MonTiengAnh implements MonHoc {
	private GiangVien giangVienChinh;
	private GiangVien troGiang;
	private String tenMonHoc;
	public MonTiengAnh() {
		super();
	}
	
	public MonTiengAnh(GiangVien giangVienChinh, GiangVien troGiang, String tenMonHoc) {
		super();
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;
		this.tenMonHoc = tenMonHoc;
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
	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	@Override
	public String thongTinMonHoc() {
		// TODO Auto-generated method stub
		return tenMonHoc +giangVienChinh.giangVien()+troGiang.giangVien();
	}

}
