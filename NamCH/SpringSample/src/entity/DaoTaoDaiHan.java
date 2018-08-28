package entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao {

	public String hedaoTao() {
		// TODO Auto-generated method stub
		return "Mời bạn đi học từ 8h30 đền 11h và 13h30 đến 17h30 \n Trong vòng 6 tháng";
	}

}
