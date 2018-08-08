package entity;

import java.util.List;

public class HocKi2 implements HocKi {
	private List<MonHoc> monCongNgheList;
	private MonHoc monTiengAnh;
	
	public HocKi2() {
		// 
	}
	
	public HocKi2(List<MonHoc> monCongNgheList, MonHoc monTiengAnh) {
		this.monCongNgheList = monCongNgheList;
		this.monTiengAnh = monTiengAnh;
	}
	
	@Override
	public String hocKi() {
		String hk = "Học kì 2 \n";
		hk+= "Môn công Nghệ: \n";
		for (MonHoc x : monCongNgheList) {
			hk += x.monHoc() + "\n";
		}
		hk+= "Môn tiếng anh: \n";
		hk+= monTiengAnh.monHoc();
		return hk;
	}
}
