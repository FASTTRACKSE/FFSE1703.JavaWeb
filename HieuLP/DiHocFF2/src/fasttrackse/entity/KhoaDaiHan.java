package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class KhoaDaiHan implements HeDaoTao {

	public String khoaDaoTao() {
		return "Trong vòng 16 tháng đi học đầy đủ";
	}

}
