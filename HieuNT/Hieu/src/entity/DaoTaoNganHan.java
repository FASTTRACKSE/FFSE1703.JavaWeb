package entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {
public DaoTaoNganHan() {
	
}
	@Override
	public String getGioHoc() {
		// TODO Auto-generated method stub
		String st=" Đào tạo ngắn hạn 6 tháng, từ 18h30 – 21h30";
		return st;
	}

}
