package asm.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao {
	public List<HocKy> hocKy;

	public DaoTaoDaiHan() {

	}

	public DaoTaoDaiHan(List<HocKy> hocKy) {
		super();
		this.hocKy = hocKy;
	}

	public String infoThoiGianHoc() {
		return "Đào Tạo Dài Hạn Trong 16 Tháng ! \n";
	}

	@Override
	public String infoDaoTao() {
		String daiHan = "Học Trong " + infoThoiGianHoc() + "\n\n";
		for (HocKy hk : hocKy) {
			daiHan += hk.infoHocKy();
		}
		return daiHan;
	}
}
