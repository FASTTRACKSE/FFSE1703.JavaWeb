package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao{

	public String getGioHoc() {
		return "Trong vòng 16 tháng, mời bạn đi học sáng từ 8h00, chiều từ 13h30";
	}

}
