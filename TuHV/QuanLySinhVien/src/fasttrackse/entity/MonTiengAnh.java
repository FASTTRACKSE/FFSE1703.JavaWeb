package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonTiengAnh implements MonHoc {
	public String tenMonHoc, trinhDo;
	public GiangVien giangVienChinh;
	public GiangVien troGiang;

	public MonTiengAnh() {
		super();
	}

	public MonTiengAnh(String tenMonHoc, String trinhDo, GiangVien giangVienChinh, GiangVien troGiang) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.trinhDo = trinhDo;
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;
	}

	@Override
	public String thongTinMonHoc() {
		String st = "  - Tên môn học: " + tenMonHoc + " - " + trinhDo + "\n";
		st += "   + Giảng viên chính: " + giangVienChinh.thongTinGiangVien() + "\n";
		st += "   + Trợ giảng: " + troGiang.thongTinGiangVien() + "\n";
		return st;
	}

}