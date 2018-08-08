package fasttrackse.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKy2 implements HocKy{

	public List<MonHoc> monCongNghe;
	public List<MonHoc> monTiengAnh;

	public HocKy2() {
		super();
	}

	public HocKy2(List<MonHoc> monCongNghe, List<MonHoc> monTiengAnh) {
		super();
		this.monCongNghe = monCongNghe;
		this.monTiengAnh = monTiengAnh;
	}

	@Override
	public String tenHocKy() {
		String st = " Tên học kỳ: Học kỳ 2 \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (MonHoc mH : monCongNghe) {
			st += mH.ttMonHoc();
		}
		st += "  * Môn tiếng Anh: \n";
		for (MonHoc mH : monTiengAnh) {
			st += mH.ttMonHoc();
		}
		return st;
	}

}
