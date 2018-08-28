package emtity;

import org.springframework.stereotype.Component;

@Component

public class DaoTaoDaiHan implements HeDaoTao {
	@Override
	public String getGioHoc() {
		return "Trong vòng 16 tháng, mời bạn đi học sáng từ 19h00, chiều từ 21h30";
	}
}
