package FFSE;

import java.util.List;

public class HocKi_4 implements HocKi {
	public List<ThucTap> ThucTap;

	public HocKi_4() {
		super();
	}

	public HocKi_4(List<ThucTap> ThucTap) {
		super();
		this.ThucTap = ThucTap;
	}

	@Override
	public String getHocKi() {
		String st = " Tên học kỳ: Học kỳ thực tập \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (ThucTap mH : ThucTap) {
			st += mH.getMonHoc();
		}
		return st;
	}
	}

