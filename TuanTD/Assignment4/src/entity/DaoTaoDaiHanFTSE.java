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
		return "16 tháng, sáng 8h30, chiều 13h30";
	}

	@Override
	public String thongTinHeDaoTao() {
		String st = " Học trong " + thongTinThoiGianHoc() + "\n\n";
		for (HocKy hK : hocKy) {
			st +=  hK.thongTinHocKy() + "\n";	
		}
		return st;
	}

}
