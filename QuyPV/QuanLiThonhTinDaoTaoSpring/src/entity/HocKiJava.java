package entity;

import java.util.List;

public class HocKiJava implements HocKi {
	private List<MonCongNghe> monCongNgheList;
	
	public HocKiJava() {
		// 
	}
	
	public HocKiJava(List<MonCongNghe> monCongNgheList) {
		this.monCongNgheList = monCongNgheList;
	}
	
	@Override
	public String hocKi() {
		String hk = "Học kì java \n";
		hk += "Môn Công nghệ chủ đề Java \n";
		for (MonCongNghe x : monCongNgheList) {
			hk += x.monHoc() + "\n";
		}
		return hk;
	}
}
