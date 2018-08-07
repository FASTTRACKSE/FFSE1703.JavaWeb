package entity;

import java.util.List;

public class HocKiJava implements HocKi {
	private List<MonHoc> monCongNgheList;
	
	public HocKiJava() {
		// 
	}
	
	public HocKiJava(List<MonHoc> monCongNgheList) {
		this.monCongNgheList = monCongNgheList;
	}
	
	@Override
	public String hocKi() {
		String hk = "Học kì java \n";
		hk += "Môn Công nghệ chủ đề Java \n";
		for (MonHoc x : monCongNgheList) {
			hk += x.monHoc() + "\n";
		}
		return hk;
	}
}
