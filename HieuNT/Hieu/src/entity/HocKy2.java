package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKy2 implements HocKi {
	public HocKy2() {

	}

	private List<MonHoc> monCongNgheList;
	private MonHoc monTiengAnh;

	public HocKy2(List<MonHoc> monCongNgheList, MonHoc monTiengAnh) {
		this.monCongNgheList = monCongNgheList;
		this.monTiengAnh = monTiengAnh;
	}

	public String HocKy() {
		// TODO Auto-generated method stub
		String st = "	" + "\n HỌC KỲ 2";
		st += "\n Môn công Nghệ: \n";
		for (MonHoc x : monCongNgheList) {
			st += "  " + x.tenMonHoc();
		}
		st += "\n Môn tiếng anh: \n";
		st += monTiengAnh.tenMonHoc();

		return st;
	}

}
