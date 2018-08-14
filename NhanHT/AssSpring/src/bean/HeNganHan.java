package bean;

import org.springframework.stereotype.Component;

@Component
public class HeNganHan implements HeDaoTao {

	public HeNganHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String heDaoTao() {
		// TODO Auto-generated method stub
		return "Hệ Ngắn Hạn 8 Tháng";
	}

}
