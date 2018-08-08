package fasttrackse.entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {
	private List<HocKy> hocKy;
	public DaoTaoNganHan() {
		
	}

public DaoTaoNganHan(List<HocKy> hocKy) {
		super();
		this.hocKy = hocKy;
	}
   
public List<HocKy> getHocKy() {
	return hocKy;
}

public void setHocKy(List<HocKy> hocKy) {
	this.hocKy = hocKy;
}

public String getDaoTao() {
	String result =  "6 tháng, sáng 10h00, chiều 17h30";
	for(HocKy x: hocKy) {
		result += "\n" + x.getHocKy();
	}
	return result;
}
}
