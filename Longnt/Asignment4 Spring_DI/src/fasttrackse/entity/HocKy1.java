package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class HocKy1 implements HocKy{
	private MonCongNghe monCongNghe;
	private MonTiengAnh monTiengAnh;
	public HocKy1(MonCongNghe monCongNghe, MonTiengAnh monTiengAnh) {
		this.monCongNghe = monCongNghe;
		this.monTiengAnh = monTiengAnh;
	}
	public HocKy1() {
		
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
	String result = "\n"+ " Học kỳ 1 " + "\n";
	result +=  monCongNghe.getMonHoc() +"\n";
	result +=  monTiengAnh.getMonHoc();
	return result;
}
}
