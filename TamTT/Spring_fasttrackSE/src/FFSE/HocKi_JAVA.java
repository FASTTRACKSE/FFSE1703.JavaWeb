package FFSE;

import java.util.List;

public class HocKi_JAVA implements HocKi{
	public List<CongNghe> CongNghe;

	public HocKi_JAVA() {
		super();
	}

	public HocKi_JAVA(List<CongNghe> CongNghe) {
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
		String st = "Tên học kỳ: Java Development \n";
		st += " Danh sách môn học: \n";
		st += " * Môn công nghê: \n";
		for (CongNghe mH : CongNghe) {
			st += mH.getMonHoc();
		}
		return st;
	}
}
