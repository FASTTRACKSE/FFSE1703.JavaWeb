package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {
	public List<HocKi> hocKi;
	public DaoTaoNganHan(List<HocKi> hocKi) {
		super();
		this.hocKi = hocKi;
	}

	public String thongTinHeDaoTao() {
		String st = "Đào tạo ngắn hạn trong 6 tháng";
		for (HocKi hK : hocKi) {
			st+= hK.tenHocKi();
		}
		return st;
	}
}
