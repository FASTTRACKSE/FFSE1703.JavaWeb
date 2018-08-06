package entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class HocKyJava implements HocKy {
	private ArrayList<MonCongNghe> monCongNghe = new ArrayList<>();
	public HocKyJava() {
		super();
	}
	
	public HocKyJava(ArrayList<MonCongNghe> monCongNghe) {
		super();
		this.monCongNghe = monCongNghe;
	}

	public ArrayList<MonCongNghe> getMonCongNghe() {
		return monCongNghe;
	}

	public void setMonCongNghe(ArrayList<MonCongNghe> monCongNghe) {
		this.monCongNghe = monCongNghe;
	}

	@Override
	public String hocKy() {
		String tenHocKy = " Java Development"+"\n";
		for (MonCongNghe x : monCongNghe) {
			tenHocKy +="\t"+ x.thongTinMonHoc() +"\n";
		}
		return tenHocKy;
	}
}
