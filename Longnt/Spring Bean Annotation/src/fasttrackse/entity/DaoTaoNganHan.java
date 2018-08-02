package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {
	@Override
	public String getGioHoc() {
		return "Trong vòng 6 tháng, mời bạn đi học sáng từ 10h00, chiều từ 17h30";
	}
}
