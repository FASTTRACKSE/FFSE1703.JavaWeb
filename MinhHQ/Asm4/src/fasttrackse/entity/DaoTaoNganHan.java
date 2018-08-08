package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao{

	public HocKy hocKy;

	public DaoTaoNganHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DaoTaoNganHan(HocKy hocKy) {
		super();
		this.hocKy = hocKy;
	}
	
	@Override
	public String khoaDaoTao() {
		String st = " Học trong 6 tháng, chiều từ 18h30 đến tối  21h30" + "\n\n";
			st +=  hocKy.tenHocKy() + "\n";	
		return st;
	}
}
