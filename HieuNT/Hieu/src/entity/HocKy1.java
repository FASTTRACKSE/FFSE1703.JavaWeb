package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKy1 implements HocKi {
	private List<MonHoc> monCongNgheList;
	private MonHoc monTiengAnh;

	public HocKy1(List<MonHoc> monCongNgheList, MonHoc monTiengAnh) {
		this.monCongNgheList = monCongNgheList;
		this.monTiengAnh = monTiengAnh;
	}
	public HocKy1() {
		
	}

	public String HocKy() {
		// TODO Auto-generated method stub
		String st = "	" + "\n HỌC KỲ 1";
		st += "\n Môn công Nghệ: \n"; 
		for (MonHoc x : monCongNgheList) {
			st +="  "+ x.tenMonHoc();
		}
		st += "\n Môn tiếng anh: \n";
		st += monTiengAnh.tenMonHoc();

		return st;
	}

}
