package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKyJava implements HocKy {
	public List<MonHoc> monCongNghe;

	public HocKyJava() {
		super();
	}

	public HocKyJava(List<MonHoc> monCongNghe) {
		super();
		this.monCongNghe = monCongNghe;
	}

	@Override
	public String thongTinHocKy() {
		String st = "Tên học kỳ: Java Development \n";
		st += " Danh sách môn học: \n";
		st += " * Môn công nghê: \n";
		for (MonHoc mH : monCongNghe) {
			st += mH.thongTinMonHoc();
		}
		return st;
	}

}
