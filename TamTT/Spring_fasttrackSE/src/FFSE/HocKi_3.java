package FFSE;

import java.util.List;

public class HocKi_3 implements HocKi {
	public List<CongNghe> CongNghe;

	public HocKi_3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HocKi_3(List<CongNghe> CongNghe) {
		super();
		this.CongNghe = CongNghe;
	}

	public List<CongNghe> getMonCongNghe() {
		return CongNghe;
	}

	public void setMonCongNghe(List<CongNghe> monCongNghe) {
		this.CongNghe = monCongNghe;
	}

	@Override
	public String getHocKi() {
		String st = " Tên học kỳ: Học kỳ chuyên đề \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (CongNghe mH : CongNghe) {
			st += mH.getMonHoc();
		}
		return st;
	}

}
