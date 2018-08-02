package model;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao{
	public String heDaoTao() {

		return "Trong Vòng 16 tháng,mời bạn đi học buổi sáng từ 10h00 đến 12h00 và buổi chiều từ 1h30 đến 5h30";
	}
}
