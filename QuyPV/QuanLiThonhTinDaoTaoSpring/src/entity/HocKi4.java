package entity;

import java.util.List;

public class HocKi4 implements HocKi {
	private List<MonHoc> monThucTapList;
	
	public HocKi4() {
		// 
	}
	
	public HocKi4(List<MonHoc> monThucTapList) {
		this.monThucTapList = monThucTapList;
	}
	
	@Override
	public String hocKi() {
		String hk = "Học kì thực tập \n";
		hk += "Môn thực tập: \n";
		for (MonHoc x : monThucTapList) {
			hk += x.monHoc() + "\n";
		}
		return hk;
	}
}
