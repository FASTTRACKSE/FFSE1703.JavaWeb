package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKyWebFullStack implements HocKy {
	public List<MonCongNghe> monCongNghe;

	public HocKyWebFullStack() {
		super();
	}

	public HocKyWebFullStack(List<MonCongNghe> monCongNghe) {
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
		String st = "Tên học kỳ: Web Fullstrack Development \n";
		st += " Danh sách môn học: \n";
		for (MonCongNghe mH : monCongNghe) {
			st += mH.thongTinMonHoc();
		}
		return st;
	}
}
