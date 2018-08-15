package entity;

import org.springframework.stereotype.Component;

@Component
public class MonCongNghe implements MonHoc {
	private GiangVienSV giangVienChinh,troGiang,mentor;
	private String tenMonHoc;
	public MonCongNghe() {
		super();
	}

	public MonCongNghe(GiangVienSV giangVienChinh, GiangVienSV troGiang, GiangVienSV mentor, String tenMonHoc) {
		super();
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;
		this.mentor = mentor;
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

	public GiangVienSV getMentor() {
		return mentor;
	}

	public void setMentor(GiangVienSV mentor) {
		this.mentor = mentor;
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
		return"\n" +"\t"+tenMonHoc +"\t" + "GV: "+giangVienChinh.thongTinGiangVien()+"\t"+"\t" + "GV: "+troGiang.thongTinGiangVien()+"\t"+"\t" + "GV: "+mentor.thongTinGiangVien();
	}

}
