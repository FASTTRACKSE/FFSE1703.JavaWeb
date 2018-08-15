package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class HocKyJava implements HocKy{
	private MonCongNghe monCongNghe;
	public HocKyJava() {
	 
	}
	public HocKyJava(MonCongNghe monCongNghe) {
		this.monCongNghe = monCongNghe;
	}
public MonCongNghe getMonCongNghe() {
		return monCongNghe;
	}
	public void setMonCongNghe(MonCongNghe monCongNghe) {
		this.monCongNghe = monCongNghe;
	}
public String getHocKy() {
	String result = "\n"+ " Học kỳ Java " + "\n";
	result += "\n" + monCongNghe.getMonHoc();
	return result;
}
}