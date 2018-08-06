package entity;

import java.util.List;

public class HocKi4 implements HocKi {
	private List<MonThucTap> monThucTapList;
	
	public HocKi4() {
		// 
	}
	
	public HocKi4(List<MonThucTap> monThucTapList) {
		this.monThucTapList = monThucTapList;
	}
	
	@Override
	public String hocKi() {
		String hk = "Học kì thực tập \n";
		hk += "Môn thực tập: \n";
		for (MonThucTap x : monThucTapList) {
			hk += x.monHoc() + "\n";
		}
		return hk;
	}
}
