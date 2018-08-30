package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao {
	public List<HocKy> hocKy;

	@Override
	public String thongTinHeDaoTao() {
		// TODO Auto-generated method stub
		String st = " Học trong " + thongTinThoiGianHoc();
		for (HocKy x : hocKy) {
			st += x.thongTinHocKy() + "\n";
		}
		return st;
	}

	@Override
	public String thongTinThoiGianHoc() {
		// TODO Auto-generated method stub
		return "16 tháng, sáng 8h30, chiều 13h30";

	}

}
