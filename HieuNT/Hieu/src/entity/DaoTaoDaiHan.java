package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao {
	private List<HocKi> listhocki;

	public DaoTaoDaiHan(List<HocKi> listhocki) {
		this.listhocki = listhocki;
	}
	public DaoTaoDaiHan() {
		
	}

	@Override
	public String getGioHoc() {
		// TODO Auto-generated method stub
		String st = "Hệ đào tạo Dài Hạn 16 tháng, Sáng 8h30, chiều 13h30 ";
		for (HocKi x : listhocki) {
			st += x.HocKy() + "\n";
		}
		return st;
		
}
	}
