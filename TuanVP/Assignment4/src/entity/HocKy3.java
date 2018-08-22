package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component

public class HocKy3 implements HocKy {
	public List<MonHoc> monCongNghe;

	public HocKy3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HocKy3(List<MonHoc> monCongNghe) {
		super();
		this.monCongNghe = monCongNghe;
	}

	@Override
	public String thongTinHocKy() {
		String st = " Tên học kỳ: Học kỳ chuyên đề \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (MonHoc mH : monCongNghe) {
			st += mH.thongTinMonHoc();
		}
		return st;
	}

}
