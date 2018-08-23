package entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MonTiengAnh implements MonHoc {
	public String tenMonHoc, trinhDo;
	public GiangVienChinh giangVienChinh;
	public TroGiang troGiang;

	public MonTiengAnh() {
		super();
	}

	public MonTiengAnh(String tenMonHoc, String trinhDo, GiangVienChinh giangVienChinh, TroGiang troGiang) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.trinhDo = trinhDo;
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;
	}

	@Override
	public String thongTinMonHoc() {
		String st = "  - Tên môn học: " + tenMonHoc + " - " + trinhDo + "\n";
		st += "   + " + giangVienChinh.thongTinGiangVien();
		st += "   + " + troGiang.thongTinGiangVien();
		return st;
	}

}
