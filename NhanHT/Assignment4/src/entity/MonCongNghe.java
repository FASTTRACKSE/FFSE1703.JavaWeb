package entity;

import org.springframework.stereotype.Component;

@Component
public class MonCongNghe implements MonHoc {
	private GiangVien giangVienChinh , giangVienPhuTrach,mentor;
	private String tenMonHoc;
	public MonCongNghe() {
		super();
	}



	
	public MonCongNghe(GiangVien giangVienChinh, GiangVien giangVienPhuTrach, GiangVien mentor, String tenMonHoc) {
		super();
		this.giangVienChinh = giangVienChinh;
		this.giangVienPhuTrach = giangVienPhuTrach;
		this.mentor = mentor;
		this.tenMonHoc = tenMonHoc;
	}




	public GiangVien getGiangVienChinh() {
		return giangVienChinh;
	}




	public void setGiangVienChinh(GiangVien giangVienChinh) {
		this.giangVienChinh = giangVienChinh;
	}




	public GiangVien getGiangVienPhuTrach() {
		return giangVienPhuTrach;
	}




	public void setGiangVienPhuTrach(GiangVien giangVienPhuTrach) {
		this.giangVienPhuTrach = giangVienPhuTrach;
	}




	public GiangVien getMentor() {
		return mentor;
	}




	public void setMentor(GiangVien mentor) {
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
		return tenMonHoc + giangVienChinh.giangVien()+ giangVienPhuTrach.giangVien()+ mentor.giangVien();
	}

}
