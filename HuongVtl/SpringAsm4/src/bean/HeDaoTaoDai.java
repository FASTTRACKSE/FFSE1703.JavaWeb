package bean;

import java.util.ArrayList;

public class HeDaoTaoDai implements HeDaoTao{
	private  ArrayList<HocKy> arrHk;
	public HeDaoTaoDai(ArrayList<HocKy> arrHk) {
		this.arrHk =  arrHk;
	}
	@Override
	public String heDaoTao() {
		// TODO Auto-generated method stub
		String a="";
		for(HocKy x:arrHk) {
			a=a+x.hocKy();
		}
		return "hệ đào tạo dài hạn\n" + a;
	}

}
