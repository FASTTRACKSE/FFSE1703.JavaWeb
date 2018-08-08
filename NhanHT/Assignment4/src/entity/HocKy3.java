package entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class HocKy3 implements HocKy {
	public ArrayList<MonCongNghe> monCongNghe ;
	public HocKy3() {
		super();
	}

	public HocKy3(ArrayList<MonCongNghe> monCongNghe) {
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
		String tenHocKy = "Học kỳ chuyên đề(Học Kỳ 3)"+"\n";
		tenHocKy += " -Môn Công Nghệ" + "\n";
		for (MonCongNghe x : monCongNghe) {
			tenHocKy += "\t"+ x.thongTinMonHoc() +"\n";
		}
		return tenHocKy;
	}

}
