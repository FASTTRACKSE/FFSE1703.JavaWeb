package asm.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {
	public List<HocKy> hocKy;

	public DaoTaoNganHan() {
	}

	public DaoTaoNganHan(List<HocKy> hocKy) {
		super();
		this.hocKy = hocKy;
	}

	public String infoDaoTao() {
		return "Học 6 Tháng, từ 18h30-21h30";
	}

	@Override
	public String infoThoiGianHoc() {
		String nganHan = "Học Trong " + infoDaoTao() + "\n\n";
		for (HocKy hk : hocKy) {
			nganHan += hk.infoHocKy() + "\n";
		}
		return nganHan;
	}
}
