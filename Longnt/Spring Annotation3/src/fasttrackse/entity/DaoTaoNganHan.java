package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {

	public DaoTaoNganHan() {
		super();
	}
	public String getDaoTao() {
		return "Sáng bắt đầu từ 10h và chiều bắt đầu từ 17h";
	}

}
