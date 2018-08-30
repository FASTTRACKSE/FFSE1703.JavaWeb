package entity;

import org.springframework.stereotype.Component;

@Component
public class TiengAnh implements MonHoc {
	private String tenMonCongNghe;
	private String giangVienChinh;

	public TiengAnh() {

	}

	public TiengAnh(String tenMonCongNghe, String giangVien) {
		this.tenMonCongNghe = tenMonCongNghe;
		this.giangVienChinh = giangVien;
	}
	public String tenMonHoc() {
		// TODO Auto-generated method stub
		return tenMonCongNghe +" "+ " GIÁO VIÊN "+" " + giangVienChinh;
	}

}
