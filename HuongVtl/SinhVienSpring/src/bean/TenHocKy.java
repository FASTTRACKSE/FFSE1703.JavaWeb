package bean;

public class TenHocKy implements HocKy {
	private String tenHocKy;
	public  TenHocKy(String tenHocKy) {
		this.tenHocKy = tenHocKy;
	}
	@Override
	public String hocKy() {
		// TODO Auto-generated method stub
		return tenHocKy;
	}

}
