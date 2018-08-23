package entity;

import org.springframework.stereotype.Component;

@Component
public class HeNganHanFTSE implements HeDaoTaoSV {
	public HocKy hocKy;

	public HeNganHanFTSE(HocKy hocKy) {
		super();
		this.hocKy = hocKy;
	}

	public HeNganHanFTSE() {
		super();
	}

	public String thoiGianHoc() {
		return "+ Hệ đào tạo Ngắn Hạn 6 tháng, Chiều 17h30, Tối 21h30";
	}

	@Override
	public String heDaoTao() {
		String st = thoiGianHoc() + "\n";
		st += "  * "+ hocKy.hocKy() + "\n";
		return st;
	}

}
