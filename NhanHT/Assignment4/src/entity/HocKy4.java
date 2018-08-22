package entity;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class HocKy4 implements HocKy {
	public ArrayList<MonThucTap> monThucTap;
	public HocKy4() {
		super();
	}
	public HocKy4(ArrayList<MonThucTap> monThucTap) {
		super();
		this.monThucTap = monThucTap;
	}
	public ArrayList<MonThucTap> getMonThucTap() {
		return monThucTap;
	}
	public void setMonThucTap(ArrayList<MonThucTap> monThucTap) {
		this.monThucTap = monThucTap;
	}

	@Override
	public String hocKy() {
		String tenHocKy = "Học kỳ thực tập(Học Kỳ 4)"+"\n";
		tenHocKy += " -Nơi thực tập" + "\n";
		for (MonThucTap x : monThucTap) {
			tenHocKy +="\t"+ x.thongTinMonHoc() +"\n";
		}
		return tenHocKy;
	}

}
