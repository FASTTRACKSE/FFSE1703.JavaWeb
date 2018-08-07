package fasttrackse.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKy3 implements HocKy{

	public List<MonHoc> monCongNghe;
	public List<MonHoc> monTiengAnh;

	public HocKy3() {
		super();
	}

	public HocKy3(List<MonHoc> monCongNghe) {
		super();
		this.monCongNghe = monCongNghe;
	}

	@Override
	public String tenHocKy() {
		String st = " Tên học kỳ: Học kỳ chuyên đề \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (MonHoc mH : monCongNghe) {
			st += mH.ttMonHoc();
		}
		return st;
	}

}
