package FFSE;

import java.util.List;

public class HocKi_1 implements HocKi {
	public List<CongNghe> CongNghe;
	public List<TiengAnh> TiengAnh;

	public HocKi_1() {
		super();
	}

	public HocKi_1(List<CongNghe> CongNghe, List<TiengAnh> TiengAnh) {
		super();
		this.CongNghe = CongNghe;
		this.TiengAnh = TiengAnh;
	}

	@Override
	public String getHocKi() {
		String st = " Tên học kỳ: Học kỳ 1 \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (CongNghe mH : CongNghe) {
			st += mH.getMonHoc();
		}
		st += "  * Môn tiếng Anh: \n";
		for (TiengAnh mH : TiengAnh) {
			st += mH.getMonHoc();
		}
		return st;
	}
}
