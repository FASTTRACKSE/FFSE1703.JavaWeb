package entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HocKy2 implements HocKy {
	public List<MonCongNghe> monCongNghe = new ArrayList<>();
	public List<MonTiengAnh> monTiengAnh = new ArrayList<>();

	public HocKy2() {
		super();
	}

	public HocKy2(List<MonCongNghe> monCongNghe, List<MonTiengAnh> monTiengAnh) {
		super();
		this.monCongNghe = monCongNghe;
		this.monTiengAnh = monTiengAnh;
	}

	@Override
	public String thongTinHocKy() {
		String st = " Tên học kỳ: Học kỳ 2 \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (MonCongNghe mH : monCongNghe) {
			st +=  mH.thongTinMonHoc();
		}
		st += "  * Môn tiếng Anh: \n";
		for (MonTiengAnh mH : monTiengAnh) {
			st += mH.thongTinMonHoc();
		}
		return st;
	}
}
