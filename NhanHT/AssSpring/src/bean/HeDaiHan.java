package bean;

import org.springframework.stereotype.Component;

@Component
public class HeDaiHan implements HeDaoTao {

	public HeDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String heDaoTao() {
		// TODO Auto-generated method stub
		return "Hệ Dài Hạn 16 Tháng";
	}

}
