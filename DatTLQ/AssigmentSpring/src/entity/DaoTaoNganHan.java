package entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {

	@Override
	public String chonKhoaHoc() {
		// TODO Auto-generated method stub
		return "Thông tin thời gian học – giờ đi học (6 tháng, từ 18h30 – 21h30)";
	}

}
