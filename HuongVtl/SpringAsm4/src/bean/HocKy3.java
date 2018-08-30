package bean;

public class HocKy3 implements HocKy{
	private MonHoc monCn;
	public HocKy3(MonHoc monCn) {
		this.monCn = monCn;
	}
	@Override
	public String hocKy() {
		// TODO Auto-generated method stub
		return "học kỳ chuyên đề\n"+monCn.monHoc();
	}

}
