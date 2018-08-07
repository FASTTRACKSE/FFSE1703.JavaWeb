package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao {
	public List<HocKi> hocKi;

	public DaoTaoDaiHan(List<HocKi> hocKi) {
		super();
		this.hocKi = hocKi;
	}

	public String thongTinHeDaoTao() {
		String st = "Đào tạo dài hạn trong 16 tháng \n";
		for (HocKi hK : hocKi) {
			st+= hK.tenHocKi();
		}
		return st;
	}
}
