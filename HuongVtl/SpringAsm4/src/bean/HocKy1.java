package bean;

import java.util.ArrayList;

public class HocKy1 implements HocKy{
	private ArrayList<MonHoc>arrMh;
	public HocKy1(ArrayList<MonHoc>arrMh) {
		this.arrMh = arrMh;
	}
	@Override
	public String hocKy() {
		// TODO Auto-generated method stub
		String a="";
		for(MonHoc x: arrMh) {
			a=a+x.monHoc();
		}
		return "hoc  ky 1\n"+a;
	}
	

}
