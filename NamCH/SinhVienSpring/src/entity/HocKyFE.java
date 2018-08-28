package entity;

import java.util.List;

public class HocKyFE implements HocKy{
	private String tenHK;
	private List<MonHoc> monHoc;
	
	public HocKyFE(String tenHK,List<MonHoc> monHoc) {	
		this.tenHK= tenHK;
		this.monHoc=monHoc;
	}
	
	@Override
	public String getTenHocKy() {
		// TODO Auto-generated method stub
		String a ="";
		for (MonHoc x : monHoc) {
			a = a + x.getTenMonHoc(); 
		}
		return tenHK +"\n\t\t-"+a;
	}	

}
