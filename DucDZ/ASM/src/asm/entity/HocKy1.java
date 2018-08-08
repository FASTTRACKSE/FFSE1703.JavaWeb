package asm.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class HocKy1 implements HocKy {
	public List<MonHoc> monCN;
	public List<MonHoc> monTA;
	public HocKy1() {
	}
	public HocKy1(List<MonHoc> monCN, List<MonHoc> monTA) {
		super();
		this.monCN = monCN;
		this.monTA = monTA;
	}

	@Override
	public String infoHocKy() {
		String hk1 = "Tên học kỳ: Học kỳ 1 \n";
		hk1 += "Danh Sách Môn Học :\n";
		hk1 += "* Môn Công Nghệ \n";
		for (MonHoc mh : monCN) {
			hk1 += mh.tenMonHoc();
		}
		hk1 += "Danh Sách Môn Học :\n";
		hk1 += "* Môn Tiếng Anh \n";
		for (MonHoc mh : monTA) {
			hk1 += mh.tenMonHoc();
		}
		return hk1;
	}
}
