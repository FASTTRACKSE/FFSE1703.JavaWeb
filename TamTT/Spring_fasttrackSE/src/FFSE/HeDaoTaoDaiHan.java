package FFSE;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class HeDaoTaoDaiHan implements HeDaoTao{
	public List<HocKi> hocKi;

	public HeDaoTaoDaiHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeDaoTaoDaiHan(List<HocKi> hocKi) {
		super();
		this.hocKi = hocKi;
	}

	@Override
	public String getGioHoc() {
		return "16 tháng, sáng 8h30, chiều 13h30";
	}

	@Override
	public String getHeDaoTao() {
		String st = " Học trong " + getGioHoc() + "\n\n";
		for (HocKi hK : hocKi) {
			st +=  hK.getHocKi() + "\n";	
		}
		return st;
	}

}