package fasttrackse.entity;
import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao{

	@Override
	public String getHocKy() {
		
		return "KHÓA ĐÀO TẠO TRONG VÒNG 16 THÁNG";
	}


}
