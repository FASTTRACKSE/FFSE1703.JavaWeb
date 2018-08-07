package entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {
	public String thongTinHeDaoTao() {
		return "Đào tạo ngắn hạn trong 6 tháng";
	}
}
