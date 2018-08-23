package annotation.entity;

import org.springframework.stereotype.Component;

@Component("daoTaoNganHan")
public class DaoTaoNganHan implements HeDaoTao {
	public String getGioHoc() {
		return "Hoc 8 thang !";
	}
}
