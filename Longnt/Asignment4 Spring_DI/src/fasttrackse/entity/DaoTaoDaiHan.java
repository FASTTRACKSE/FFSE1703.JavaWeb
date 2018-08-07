package fasttrackse.entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("Prototype")
public class DaoTaoDaiHan implements HeDaoTao {
	private List<HocKy> hocKy;
	public DaoTaoDaiHan() {
		
	}

public DaoTaoDaiHan(List<HocKy> hocKy) {
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
	String result =  "16 tháng, sáng 80h00, chiều 13h30";
	for(HocKy x: hocKy) {
		result += "\n" + x.getHocKy();
	}
	return result;
}

}
