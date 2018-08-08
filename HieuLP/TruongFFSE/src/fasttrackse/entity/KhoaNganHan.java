package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class KhoaNganHan implements HeDaoTao {
	public String khoaDaoTao() {
		return "Trong vòng 8 tháng,mời bạn đi học tối từ 18h30 đến 21h30!";
	}
}
