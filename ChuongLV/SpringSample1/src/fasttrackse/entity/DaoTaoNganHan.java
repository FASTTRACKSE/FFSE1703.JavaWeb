package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {

	@Override
	public String getGioHoc() {
		return "Trong vòng 6 tháng, mời bạn đi học buổi tối từ 18h30 đến 21h30";
	}

}