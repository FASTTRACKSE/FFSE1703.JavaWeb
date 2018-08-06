package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKyJava implements HocKy {
	public List<MonCongNghe> monCongNghe;

	public HocKyJava() {
		super();
	}

	public HocKyJava(List<MonCongNghe> monCongNghe) {
		super();
		this.monCongNghe = monCongNghe;
	}

	public List<MonCongNghe> getMonCongNghe() {
		return monCongNghe;
	}

	public void setMonCongNghe(List<MonCongNghe> monCongNghe) {
		this.monCongNghe = monCongNghe;
	}

	@Override
	public String thongTinHocKy() {
		String st = "Tên học kỳ: Java Development \n";
		st += " Danh sách môn học: \n";
		st += " * Môn công nghê: \n";
		for (MonCongNghe mH : monCongNghe) {
			st += mH.thongTinMonHoc();
		}
		return st;
	}

}
