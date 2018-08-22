package asm.entity;

import java.util.List;

public class HocKyWebFullStack implements HocKy {
	public List<MonHoc> webFull;

	public HocKyWebFullStack() {
		super();
	}

	public HocKyWebFullStack(List<MonHoc> webFull) {
		super();
		this.webFull = webFull;
	}

	@Override
	public String infoHocKy() {
		String hkwebfull = "Tên Học Kỳ: Web Fullstack \n";
		hkwebfull += "Danh Sách Môn Học \n";
		for (MonHoc mh : webFull) {
			hkwebfull += mh.tenMonHoc();
		}
		return hkwebfull;
	}
}
