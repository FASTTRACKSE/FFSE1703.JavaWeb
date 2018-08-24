package asm.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class HocKy4 implements HocKy {
	public List<MonHoc> monTT;
	public HocKy4() {
		super();
	}
	public HocKy4(List<MonHoc>monTT) {
		super();
		this.monTT=monTT;
	}
	@Override
	public String infoHocKy() {
		String hk4 ="Tên Học Kỳ: Học Kỳ Thực Tập \n ";
		hk4 += "Danh Sách Môn Học: \n";
		hk4 += "* Môn Công Nghệ: \n";
		for(MonHoc mh : monTT) {
			hk4 += mh.tenMonHoc();
		}
		return hk4;
	}

}
