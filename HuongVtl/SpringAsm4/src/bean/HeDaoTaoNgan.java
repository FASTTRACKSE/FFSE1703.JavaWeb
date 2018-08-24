package bean;

import java.util.ArrayList;

public class HeDaoTaoNgan implements HeDaoTao{
	private ArrayList<HocKy> arrHk;
	public HeDaoTaoNgan (ArrayList<HocKy> arrHk) {
		this.arrHk = arrHk;
	}
	@Override
	public String heDaoTao() {
		// TODO Auto-generated method stub
		String a ="";
		for(HocKy x: arrHk) {
			a=a+x.hocKy();
		}
		return "Hệ đào tạo ngắn hạn\n";
	}

}
