package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao {
	public DaoTaoDaiHan() {
		super();
	}
	public String getDaoTao() {
		return "Sáng bắt đầu từ 7h30 và chiều bắt đầu từ 13h30";
	}

}
