package fasttrackse.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKy1 implements HocKy {
	public List<MonHoc> monCongNghe;
	public List<MonHoc> monTiengAnh;

	public HocKy1() {
		super();
	}

	public HocKy1(List<MonHoc> monCongNghe, List<MonHoc> monTiengAnh) {
		super();
		this.monCongNghe = monCongNghe;
		this.monTiengAnh = monTiengAnh;
	}

	@Override
	public String thongTinHocKy() {
		String st = " Tên học kỳ: Học kỳ 1 \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (MonHoc mH : monCongNghe) {
			st += mH.thongTinMonHoc();
		}
		st += "  * Môn tiếng Anh: \n";
		for (MonHoc mH : monTiengAnh) {
			st += mH.thongTinMonHoc();
		}
		return st;
	}
}