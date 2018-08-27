package SinhVienAss4.entity;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKy3 implements HocKy {
	public List<MonHoc> monCongNghe;
	
	public HocKy3(List<MonHoc> monCongNghe) {
		super();
		this.monCongNghe = monCongNghe;
	}

	@Override
	public String hocKy() {
		String st = " Tên h�?c kỳ: H�?c kỳ chuyên đ�? \n";
		st += " Danh sách môn h�?c: \n";
		st += "  * Môn Công Nghê: \n";
		for (MonHoc mH : monCongNghe) {
			st += mH.monHoc();
		}
		return st;

}
}
