package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class HocKy3 implements HocKy{
	private MonCongNghe monCongNghe;
	public HocKy3(MonCongNghe monCongNghe) {
		this.monCongNghe = monCongNghe;
	}
	public HocKy3() {
	
	}
	
public MonCongNghe getMonCongNghe() {
		return monCongNghe;
	}
	public void setMonCongNghe(MonCongNghe monCongNghe) {
		this.monCongNghe = monCongNghe;
	}
public String getHocKy() {
	String result = "\n"+ " Học kỳ chyên đề " + "\n";
	result += "\n" + monCongNghe.getMonHoc();
	return result;
}
}

