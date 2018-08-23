package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class KhoaNganHan implements HeDaoTao {
	public String khoaDaoTao() {
		return "Trong vòng 8 tháng đi học đầy đủ";
	}
}
