package entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DaoTaoNganHanFTSE implements HeDaoTao {
	public HocKy hocKy;

	public DaoTaoNganHanFTSE() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DaoTaoNganHanFTSE(HocKy hocKy) {
		super();
		this.hocKy = hocKy;
	}

	@Override
	public String thongTinThoiGianHoc() {
		return "6 tháng, từ 18h30-21h30";
	}

	@Override
	public String thongTinHeDaoTao() {
		String st = " Học trong " + thongTinThoiGianHoc() + "\n\n";
		st += " "+hocKy.thongTinHocKy() + "\n";
		return st;
	}

}
