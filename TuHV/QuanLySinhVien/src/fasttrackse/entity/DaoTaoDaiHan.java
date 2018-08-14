package fasttrackse.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao {
	public List<HocKy> hocKy;

	public DaoTaoDaiHan() {
		super();

	}

	public DaoTaoDaiHan(List<HocKy> hocKy) {
		super();
		this.hocKy = hocKy;
	}

	public String thongTinThoiGianHoc() {
		return "16 tháng, sáng 8h30, chiều 13h30";
	}

	public String thongTinHeDaoTao() {
		String st = " Học trong " + thongTinThoiGianHoc() + "\n\n";
		for (HocKy hK : hocKy) {
			st += hK.thongTinHocKy() + "\n";
		}
		return st;
	}

}
