package entity;

import java.util.List;

public class HocKi1 implements HocKi {
	private List<MonCongNghe> monCongNgheList;
	private MonTiengAnh monTiengAnh;
	
	public HocKi1() {
		// 
	}
	
	public HocKi1(List<MonCongNghe> monCongNgheList, MonTiengAnh monTiengAnh) {
		this.monCongNgheList = monCongNgheList;
		this.monTiengAnh = monTiengAnh;
	}
	
	@Override
	public String hocKi() {
		String hk = "Học kì 1 \n";
		hk+= "Môn công Nghệ: \n";
		for (MonCongNghe x : monCongNgheList) {
			hk += x.monHoc() + "\n";
		}
		hk+= "Môn tiếng anh: \n";
		hk+= monTiengAnh.monHoc();
		return hk;
	}

}
