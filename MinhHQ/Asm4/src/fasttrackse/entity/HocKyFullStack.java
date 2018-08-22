package fasttrackse.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKyFullStack implements HocKy{
	public List<MonHoc> monCongNghe;

	public HocKyFullStack() {
		super();
	}

	public HocKyFullStack(List<MonHoc> monCongNghe) {
		super();
		this.monCongNghe = monCongNghe;
	}

	@Override
	public String tenHocKy() {
		String st = "Tên học kỳ: Web Fullstrack Development \n";
		st += " Danh sách môn học: \n";
		for (MonHoc mH : monCongNghe) {
			st += mH.ttMonHoc();
		}
		return st;
	}
}
