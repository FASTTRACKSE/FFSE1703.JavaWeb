package bean;

import java.util.ArrayList;

public class MonCongNghe implements MonHoc{
	private ArrayList<MonHoc>arrMh;
	public MonCongNghe(ArrayList<MonHoc>arrMh) {
		this.arrMh=arrMh;
	}
	@Override
	public String monHoc() {
		// TODO Auto-generated method stub
		String a = "";
		for(MonHoc x: arrMh) {
			a=a + x.monHoc();
		}
		return "môn công nghệ \n"+a;
	}

}
