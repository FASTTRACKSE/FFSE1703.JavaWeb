package bean;

public class HocKy4 implements HocKy{
	private MonHoc monTt;
	public HocKy4(MonHoc monTt) {
		this.monTt = monTt;
	}
	@Override
	public String hocKy() {
		// TODO Auto-generated method stub
		return "học kỳ thực tập\n"+monTt.monHoc();
	}

}
