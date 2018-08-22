package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonThucTap implements MonHoc{
	private String noiThucTap;
	private GiangVien giangVien;
	
	public MonThucTap() {
		
	}

	public String getNoiThucTap() {
		return noiThucTap;
	}

	public void setNoiThucTap(String noiThucTap) {
		this.noiThucTap = noiThucTap;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	@Override
	public String chonMonHoc() {
		return "\n     - Nơi thực tập: "+ noiThucTap+"\n     -Giảng viên phụ trách:"+giangVien.getGiangVien();
	}
	
}