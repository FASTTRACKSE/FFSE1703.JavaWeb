package entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao {
	public String thongTinHeDaoTao() {
		return "Đào tạo dài hạn trong 16 tháng";
	}
}
