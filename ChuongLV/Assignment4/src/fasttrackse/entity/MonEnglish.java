package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonEnglish implements MonHoc{
	private String tenMonHoc;
	private String trinhDo;
	private GiangVien giangVien;
	private GiangVien troGiang;
	
	public MonEnglish() {
	
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public GiangVien getTroGiang() {
		return troGiang;
	}

	public void setTroGiang(GiangVien troGiang) {
		this.troGiang = troGiang;
	}

	@Override
	public String chonMonHoc() {
		return "    - " +tenMonHoc+ "   -" + trinhDo +"\n    - Giang viên:"+giangVien.getGiangVien()+"\n    -Trợ giảng:" +troGiang.getGiangVien();
		
	}
	
}