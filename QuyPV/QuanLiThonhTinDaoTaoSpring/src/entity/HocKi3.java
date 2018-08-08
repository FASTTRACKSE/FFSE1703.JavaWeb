package entity;

import java.util.ArrayList;
import java.util.List;

public class HocKi3 implements HocKi {
	public List<MonHoc> monCongNgheList;
	
	public HocKi3() {
		//
	}
	
	public HocKi3(List<MonHoc> monCongNgheList) {
		this.monCongNgheList = monCongNgheList;
	}
	
	@Override
	public String hocKi() {
		String hk = "Học kì chuyên đề \n";
		for (MonHoc x : monCongNgheList) {
			hk+= x.monHoc() + "\n";
		}
		return hk;
	}
}
