package entity;

import java.util.List;

public class HocKi2 implements HocKi {
	private List<MonCongNghe> monCongNgheList;
	private MonTiengAnh monTiengAnh;
	
	public HocKi2() {
		// 
	}
	
	public HocKi2(List<MonCongNghe> monCongNgheList, MonTiengAnh monTiengAnh) {
		this.monCongNgheList = monCongNgheList;
		this.monTiengAnh = monTiengAnh;
	}
	
	@Override
	public String hocKi() {
		String hk = "Học kì 2 \n";
		hk+= "Môn công Nghệ: \n";
		for (MonCongNghe x : monCongNgheList) {
			hk += x.monHoc() + "\n";
		}
		hk+= "Môn tiếng anh: \n";
		hk+= monTiengAnh.monHoc();
		return hk;
	}
}
