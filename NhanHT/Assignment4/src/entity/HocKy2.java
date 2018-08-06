package entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class HocKy2 implements HocKy {
	public ArrayList<MonCongNghe> monCongNghe ;
	public ArrayList<MonTiengAnh> monTiengAnh ;
	public HocKy2() {
		super();
	}

	public HocKy2(ArrayList<MonCongNghe> monCongNghe, ArrayList<MonTiengAnh> monTiengAnh) {
		super();
		this.monCongNghe = monCongNghe;
		this.monTiengAnh = monTiengAnh;
	}

	public ArrayList<MonCongNghe> getMonCongNghe() {
		return monCongNghe;
	}

	public void setMonCongNghe(ArrayList<MonCongNghe> monCongNghe) {
		this.monCongNghe = monCongNghe;
	}

	public ArrayList<MonTiengAnh> getMonTiengAnh() {
		return monTiengAnh;
	}

	public void setMonTiengAnh(ArrayList<MonTiengAnh> monTiengAnh) {
		this.monTiengAnh = monTiengAnh;
	}

	@Override
	public String hocKy() {
		String tenHocKy = "Học Kỳ 2"+"\n";
		tenHocKy += " -Môn Công Nghệ" + "\n";
		for (MonCongNghe x : monCongNghe) {
			tenHocKy +="\t"+ x.thongTinMonHoc() +"\n";
		}
		tenHocKy += " -Môn Tiếng Anh"+ "\n";
		for (MonTiengAnh x : monTiengAnh) {
			tenHocKy +="\t"+ x.thongTinMonHoc()+"\n";
		}
		return tenHocKy;
	}

}
