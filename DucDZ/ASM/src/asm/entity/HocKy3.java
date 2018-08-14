package asm.entity;

import java.util.List;

public class HocKy3 implements HocKy{
	public List<MonHoc> monCN;
	public HocKy3() {
		super();
	}
	public HocKy3(List<MonHoc> monCN) {
		super();
		this.monCN=monCN;
	}
	@Override
	public String infoHocKy() {
		String hk3 = "Tên Học Kỳ: Học Kỳ Chuyên Đề \n" ;
		hk3 += "Danh Sách Môn Học : \n";
		hk3 += "* Môn Công Nghệ : \n";
		for(MonHoc mh : monCN) {
			hk3 += mh.tenMonHoc();
		}
		return hk3;
	}

}
