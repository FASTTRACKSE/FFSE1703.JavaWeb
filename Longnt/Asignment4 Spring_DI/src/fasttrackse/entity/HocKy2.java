package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class HocKy2 implements HocKy{
	private MonCongNghe monCongNghe;
	private MonTiengAnh monTiengAnh;
	public HocKy2(MonCongNghe monCongNghe, MonTiengAnh monTiengAnh) {
		this.monCongNghe = monCongNghe;
		this.monTiengAnh = monTiengAnh;
	}
	public HocKy2() {
		
	}
	
public MonCongNghe getMonCongNghe() {
		return monCongNghe;
	}
	public void setMonCongNghe(MonCongNghe monCongNghe) {
		this.monCongNghe = monCongNghe;
	}
	public MonTiengAnh getMonTiengAnh() {
		return monTiengAnh;
	}
	public void setMonTiengAnh(MonTiengAnh monTiengAnh) {
		this.monTiengAnh = monTiengAnh;
	}
public String getHocKy() {
	String result = " Học kỳ 2 " + "\n";
	result += "\n" + monCongNghe.getMonHoc();
	result += "\n" + monTiengAnh.getMonHoc();
	return result;
}
}
