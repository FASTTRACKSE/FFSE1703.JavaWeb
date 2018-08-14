package fasttrackse.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao{

	public List<HocKy> hocKy;

	public DaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DaoTaoDaiHan(List<HocKy> hocKy) {
		super();
		this.hocKy = hocKy;
	}
	
	@Override
	public String khoaDaoTao() {
		String st = " Học trong 16 tháng, sáng 8h30, chiều 13h30" + "\n\n";
		for (HocKy hK : hocKy) {
			st +=  hK.tenHocKy() + "\n";	
		}
		return st;
	}
}
