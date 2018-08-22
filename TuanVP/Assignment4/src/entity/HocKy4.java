package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKy4 implements HocKy {
	public List<MonHoc> monThucTap;

	public HocKy4() {
		super();
	}

	public HocKy4(List<MonHoc> monThucTap) {
		super();
		this.monThucTap = monThucTap;
	}

	@Override
	public String thongTinHocKy() {
		String st = " Tên học kỳ: Học kỳ thực tập \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (MonHoc mH : monThucTap) {
			st += mH.thongTinMonHoc();
		}
		return st;
	}

}
