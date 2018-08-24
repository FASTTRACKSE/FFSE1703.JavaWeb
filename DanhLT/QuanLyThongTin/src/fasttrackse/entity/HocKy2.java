package fasttrackse.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKy2 implements HocKy {
	public List<MonHoc> monCongNghe = new ArrayList<>();
	public List<MonHoc> monTiengAnh = new ArrayList<>();

	public HocKy2() {
		super();
	}

	public HocKy2(List<MonHoc> monCongNghe, List<MonHoc> monTiengAnh) {
		super();
		this.monCongNghe = monCongNghe;
		this.monTiengAnh = monTiengAnh;
	}

	@Override
	public String thongTinHocKy() {
		String st = " Tên học kỳ: Học kỳ 2 \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (MonHoc mH : monCongNghe) {
			st +=  mH.thongTinMonHoc();
		}
		st += "  * Môn tiếng Anh: \n";
		for (MonHoc mH : monTiengAnh) {
			st += mH.thongTinMonHoc();
		}
		return st;
	}
}
