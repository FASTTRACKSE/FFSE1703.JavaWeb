package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HeDaiHan implements HeDaoTao {
	
	private List<HocKi> listhocki;
	
	public HeDaiHan() {
		//
	}
	
	public HeDaiHan(List<HocKi> listhocki) {
		this.listhocki = listhocki;
	}

	@Override
	public String heDaoTao() {
		String he = "Hệ đào tạo Dài Hạn 16 tháng, Sáng 8h30, chiều 13h30 \n";
		for (HocKi x : listhocki) {
			he += x.hocKi() + "\n";
		}
		return he ;
	}

}
