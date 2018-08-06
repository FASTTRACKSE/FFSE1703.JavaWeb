package bean;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class HocKy implements HocKySV {
	private String tenHocKy;
	private ArrayList<MonHoc> monHoc;
	public HocKy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HocKy(String tenHocKy,ArrayList<MonHoc> monHoc) {
		super();
		this.tenHocKy = tenHocKy;
		this.monHoc = monHoc;
	}

	public String getTenHocKy() {
		return tenHocKy;
	}

	public void setTenHocKy(String tenHocKy) {
		this.tenHocKy = tenHocKy;
	}

	@Override
	public void hocKy() {
		// TODO Auto-generated method stub
		System.out.println(tenHocKy);
		 for(MonHoc x:monHoc) {
			System.out.println(x.monHoc());
		} ;
	}
	
}
