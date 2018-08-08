package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class HocKy4 implements HocKy{
	private MonThucTap monThucTap;
	public HocKy4(MonCongNghe monCongNghe) {
		this.monThucTap = monThucTap;
	}
	public HocKy4() {
	 
	}
	
public MonThucTap getMonThucTap() {
		return monThucTap;
	}
	public void setMonThucTap(MonThucTap monThucTap) {
		this.monThucTap = monThucTap;
	}
public String getHocKy() {
	String result = "\n"+ " Học kỳ thực tập " + "\n";
	result += "\n" + monThucTap.getMonHoc();
	return result;
}
}
