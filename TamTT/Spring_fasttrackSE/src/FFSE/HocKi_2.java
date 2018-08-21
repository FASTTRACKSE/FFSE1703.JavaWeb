package FFSE;

import java.util.ArrayList;
import java.util.List;

public class HocKi_2 implements HocKi{
	public List<CongNghe> CongNghe = new ArrayList<>();
	public List<TiengAnh> TiengAnh = new ArrayList<>();

	public HocKi_2() {
		super();
	}

	public HocKi_2(List<CongNghe> CongNghe, List<TiengAnh> TiengAnh) {
		super();
		this.CongNghe = CongNghe;
		this.TiengAnh = TiengAnh;
	}

	@Override
	public String getHocKi() {
		String st = " Tên học kỳ: Học kỳ 2 \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (CongNghe mH : CongNghe) {
			st +=  mH.getMonHoc();
		}
		st += "  * Môn tiếng Anh: \n";
		for (TiengAnh mH : TiengAnh) {
			st += mH.getMonHoc();
		}
		return st;
	}
}
