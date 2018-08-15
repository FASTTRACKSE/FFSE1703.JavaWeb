package entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DaoTaoDaiHanFTSE implements HeDaoTao {
	public List<HocKy> hocKy;
	public DaoTaoDaiHanFTSE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DaoTaoDaiHanFTSE(List<HocKy> hocKy) {
		super();
		this.hocKy = hocKy;
	}
	@Override
	public String thongTinThoiGianHoc() {
		return "Trong Vòng 16 tháng,mời bạn đi học buổi sáng từ 10h00 đến 12h00 và buổi chiều từ 1h30 đến 5h30";
	}
	@Override
	public String thongTinHeDaoTao() {
		String st = " Học trong " + thongTinThoiGianHoc() + "\n\n";
		for (HocKy hK : hocKy) {
			st += hK.thongTinHocKy() + "\n";
		}
		return st;
	}
}
