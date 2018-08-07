package entity;

import java.util.List;

import org.springframework.stereotype.Component;
	
@Component
public class HeDaiHanFTSE implements HeDaoTaoSV {
	public List<HocKy> hocKy;

	public HeDaiHanFTSE() {
		super();
	}
	
	public HeDaiHanFTSE(List<HocKy> hocKy) {
		super();
		this.hocKy = hocKy;
	}

	public String thoiGianHoc() {
		return " + Hệ đào tạo Dài Hạn 16 tháng, Sáng 8h30, chiều 17h30";
	}
	
	@Override
	public String heDaoTao() {
		String st =thoiGianHoc() + "\n";	
		for (HocKy x : hocKy) {
			st += "  * "+ x.hocKy() + "\n";	
		}
		return st;
	}
	
}
