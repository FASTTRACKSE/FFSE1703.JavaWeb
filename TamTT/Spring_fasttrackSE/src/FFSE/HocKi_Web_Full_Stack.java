package FFSE;

import java.util.List;

public class HocKi_Web_Full_Stack implements HocKi {
	public List<CongNghe> CongNghe;

	public HocKi_Web_Full_Stack() {
		super();
	}

	public HocKi_Web_Full_Stack(List<CongNghe> CongNghe) {
		super();
		this.CongNghe = CongNghe;
	}

	public List<CongNghe> getCongNghe() {
		return CongNghe;
	}

	public void setCongNghe(List<CongNghe> CongNghe) {
		this.CongNghe = CongNghe;
	}

	@Override
	public String getHocKi() {
		String st = "Tên học kỳ: Web Fullstrack Development \n";
		st += " Danh sách môn học: \n";
		for (CongNghe mH : CongNghe) {
			st += mH.getMonHoc();
		}
		return st;
	}
}
