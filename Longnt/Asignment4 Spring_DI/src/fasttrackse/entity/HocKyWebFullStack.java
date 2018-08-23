package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class HocKyWebFullStack implements HocKy{
	private MonCongNghe monCongNghe;
	public HocKyWebFullStack() {
	 
	}
	public HocKyWebFullStack(MonCongNghe monCongNghe) {
		this.monCongNghe = monCongNghe;
	}
public MonCongNghe getMonCongNghe() {
		return monCongNghe;
	}
	public void setMonCongNghe(MonCongNghe monCongNghe) {
		this.monCongNghe = monCongNghe;
	}
public String getHocKy() {
	String result = "\n"+ " Học kỳ Web Full Stack " + "\n";
	result += "\n" + monCongNghe.getMonHoc();
	return result;
}
}
