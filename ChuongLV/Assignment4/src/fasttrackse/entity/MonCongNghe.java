package fasttrackse.entity;

//pimport java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MonCongNghe implements MonHoc {
	private String tenMonHoc;
	private GiangVien giangVien;
	private GiangVien troGiang;
	private GiangVien mentor;

	public MonCongNghe() {

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

	@Override
	public String chonMonHoc() {
		
		String result = "\n    +" + tenMonHoc;

		result += "\n    - Giang viên : " + giangVien.getGiangVien() + "\n    - Trợ giảng : " + troGiang.getGiangVien()
				+ "\n    - mentor: " + mentor.getGiangVien();
		return result;
	}

}
