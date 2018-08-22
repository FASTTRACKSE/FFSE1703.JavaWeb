package entity;

public class HocKySV implements HocKy {
	private String tenHK;
	public HocKySV(String tenHocKy) {
		// TODO Auto-generated constructor stub
		this.tenHK = tenHocKy;
	}
	@Override
	public void getTenHocKy() {
		// TODO Auto-generated method stub
		System.out.println(tenHK);
	}
	public String getTenHK() {
		return tenHK;
	}
	public void setTenHocKy(String tenHocKy) {
		this.tenHK = tenHocKy;
	}

}
