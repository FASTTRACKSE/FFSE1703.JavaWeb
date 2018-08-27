package SinhVienAss4.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKy2 implements HocKy {
	public List<MonHoc> monCongNghe;
	public List<MonHoc> monTiengAnh;
	
	public HocKy2(List<MonHoc> monCongNghe, List<MonHoc> monTiengAnh) {
		super();
		this.monCongNghe = monCongNghe;
		this.monTiengAnh = monTiengAnh;
	}

	@Override
	public String hocKy() {
		String st = " Tên h�?c kỳ: H�?c kỳ 1 \n";
		st += " Danh sách môn h�?c: \n";
		st += "  * Môn Công Nghê: \n";
		for (MonHoc mH : monCongNghe) {
			st += mH.monHoc();
		}
		st += "  * Môn tiếng Anh: \n";
		for (MonHoc mH : monTiengAnh) {
			st += mH.monHoc();
		}
		return st;
	}
}
