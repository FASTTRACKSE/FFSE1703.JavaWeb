package annotation.entity;

import org.springframework.stereotype.Component;

@Component("daoTaoDaiHan")
public class DaoTaoDaiHan implements HeDaoTao {
	public String getGioHoc() {
		return "Hoc 16 thang !";
	}
}
