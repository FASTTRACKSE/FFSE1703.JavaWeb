package entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HocKy4 implements HocKy {
	public List<MonThucTap> monThucTap;

	public HocKy4() {
		super();
	}

	public HocKy4(List<MonThucTap> monThucTap) {
		super();
		this.monThucTap = monThucTap;
	}

	@Override
	public String thongTinHocKy() {
		String st = " Tên học kỳ: Học kỳ thực tập \n";
		st += " Danh sách môn học: \n";
		st += "  * Môn Công Nghê: \n";
		for (MonThucTap mH : monThucTap) {
			st += mH.thongTinMonHoc();
		}
		return st;
	}

}
