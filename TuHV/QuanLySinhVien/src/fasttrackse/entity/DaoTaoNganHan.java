package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao{

	@Override
	public String getHocKy() {
	
		return "KHÓA ĐÀO TẠO TRONG VÒNG 6 THÁNG";
	}
	

}
