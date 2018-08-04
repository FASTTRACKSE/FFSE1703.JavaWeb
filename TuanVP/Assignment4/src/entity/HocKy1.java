package entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HocKy1 implements HocKy {
	public List<MonCongNghe> monCongNghe;
	public List<MonTiengAnh> monTiengAnh;

	public HocKy1() {
		super();
	}

	public HocKy1(List<MonCongNghe> monCongNghe, List<MonTiengAnh> monTiengAnh) {
		super();
		this.monCongNghe = monCongNghe;
		this.monTiengAnh = monTiengAnh;
	}

	@Override
	public String thongTinHocKy() {
		String st = " Tên học kỳ: Học kỳ 1 \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (MonCongNghe mH : monCongNghe) {
			st += mH.thongTinMonHoc();
		}
		st += "  * Môn tiếng Anh: \n";
		for (MonTiengAnh mH : monTiengAnh) {
			st += mH.thongTinMonHoc();
		}
		return st;
	}
}
