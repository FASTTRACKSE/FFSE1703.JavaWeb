package entity;

import java.util.List;

public class HocKiWebFullStack implements HocKi {
	
private List<MonHoc> monCongNgheList;
	
	public HocKiWebFullStack() {
		// 
	}
	
	public HocKiWebFullStack(List<MonHoc> monCongNgheList) {
		this.monCongNgheList = monCongNgheList;
	}
	@Override
	public String hocKi() {
		String hk = "Học kì Web full stack \n";
		hk += "Môn Công nghệ chủ đề Web full stack \n";
		for (MonHoc x : monCongNgheList) {
			hk += x.monHoc() + "\n";
		}
		return hk;
	}
}
