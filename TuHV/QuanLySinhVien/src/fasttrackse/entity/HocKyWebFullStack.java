package fasttrackse.entity;

import java.util.List;
import org.springframework.stereotype.Component;

@Component

public class HocKyWebFullStack  implements HocKy{
	public List<MonHoc> monCongNghe;

	public HocKyWebFullStack() {
		super();
	}

	public HocKyWebFullStack(List<MonHoc> monCongNghe) {
		super();
		this.monCongNghe = monCongNghe;
	}

	public String thongTinHocKy() {
		String st = "Tên học kỳ: Web Fullstrack Development \n";
		st += " Danh sách môn học: \n";
		for (MonHoc mH : monCongNghe) {
			st += mH.thongTinMonHoc();
		}
		return st;
	}
}
