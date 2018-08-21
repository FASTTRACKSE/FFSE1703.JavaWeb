package asm.entity;

import java.util.List;

public class HocKy2 implements HocKy{
	public List<MonHoc> monCN;
	public List<MonHoc> monTA;
	public HocKy2() {
	}
	public HocKy2(List<MonHoc> monCN, List<MonHoc> monTA) {
		super();
		this.monCN = monCN;
		this.monTA = monTA;
	}

	@Override
	public String infoHocKy() {
		String hk2 = "Tên học kỳ: Học kỳ 1 \n";
		hk2 += "Danh Sách Môn Học :\n";
		hk2 += "* Môn Công Nghệ \n";
		for (MonHoc mh : monCN) {
			hk2 += mh.tenMonHoc();
		}
		hk2 += "Danh Sách Môn Học :\n";
		hk2 += "* Môn Tiếng Anh \n";
		for (MonHoc mh : monTA) {
			hk2 += mh.tenMonHoc();
		}
		return hk2;
	}
}
