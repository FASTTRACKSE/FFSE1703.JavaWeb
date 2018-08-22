package asm.entity;

import java.util.List;

public class HocKyJava implements HocKy{
	public List<MonHoc> Java;
	public HocKyJava() {
		super();
	}
	public HocKyJava(List<MonHoc>Java) {
		super();
		this.Java=Java;
	}
	@Override
	public String infoHocKy() {
		String hkjv = "Tên Học Kỳ: Học Kỳ Java \n";
		hkjv += "Danh Sách Môn Học: \n";
		hkjv += "* Môn Công Nghệ \n";
		for(MonHoc mh : Java) {
			hkjv += mh.tenMonHoc();
		}
		return hkjv;
	}

}
