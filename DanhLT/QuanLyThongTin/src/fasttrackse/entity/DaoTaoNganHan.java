package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {
	public HocKy hocKy;

	public DaoTaoNganHan() {
		super();

	}

	public DaoTaoNganHan(HocKy hocKy) {
		super();
		this.hocKy = hocKy;
	}

	public String thongTinThoiGianHoc() {
		return "6 tháng, từ 18h30-21h30";
	}

	public String thongTinHeDaoTao() {
		String st = " Học trong " + thongTinThoiGianHoc() + "\n\n";
		st += " " + hocKy.thongTinHocKy() + "\n";
		return st;
	}

}



