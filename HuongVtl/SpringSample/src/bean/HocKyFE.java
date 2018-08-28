package bean;

public class HocKyFE implements HocKy{
	private String tenHocKy;
	public HocKyFE(String tenHocKy) {
		this.tenHocKy = tenHocKy;
	}
	@Override
	public String hocKi() {
		// TODO Auto-generated method stub
		return "hoc kỳ"+tenHocKy;
	}

}
