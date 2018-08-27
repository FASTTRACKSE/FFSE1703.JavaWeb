package bean;

import java.util.ArrayList;

public class HocKy2 implements HocKy{
	private ArrayList<MonHoc>arrMh;
	public HocKy2(ArrayList<MonHoc>arrMh) {
		this.arrMh = arrMh;
	}
	@Override
	public String hocKy() {
		// TODO Auto-generated method stub
		String a ="";
		for(MonHoc x: arrMh) {
			a=a+x.monHoc();
		}
		return "học kỳ 2\n"+a;
	}

}
