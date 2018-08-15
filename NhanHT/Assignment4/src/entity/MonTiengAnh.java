package entity;

import org.springframework.stereotype.Component;

@Component
public class MonTiengAnh implements MonHoc {
	private GiangVienSV giangVienChinh;
	private GiangVienSV troGiang;
	private String tenMonHoc;
	public MonTiengAnh() {
		super();
	}
	
	public MonTiengAnh(GiangVienSV giangVienChinh, GiangVienSV troGiang, String tenMonHoc) {
		super();
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;
		this.tenMonHoc = tenMonHoc;
	}
	public GiangVienSV getGiangVienChinh() {
		return giangVienChinh;
	}
	public void setGiangVienChinh(GiangVienSV giangVienChinh) {
		this.giangVienChinh = giangVienChinh;
	}
	public GiangVienSV getTroGiang() {
		return troGiang;
	}
	public void setTroGiang(GiangVienSV troGiang) {
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
		return "\n" +"\t"+tenMonHoc +"\t" + "GV: "+giangVienChinh.thongTinGiangVien()+"\t" + "GV: "+troGiang.thongTinGiangVien();
	}

}
