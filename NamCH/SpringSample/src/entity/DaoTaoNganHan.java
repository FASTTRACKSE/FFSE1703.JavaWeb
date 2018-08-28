package entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {

	public String hedaoTao() {
		// TODO Auto-generated method stub
		return "Mời bạn đi học từ 18h đến 21h30 \nTrong vòng 3 tháng";
	}

}
