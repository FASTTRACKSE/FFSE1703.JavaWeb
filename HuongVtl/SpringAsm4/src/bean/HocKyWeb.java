package bean;

public class HocKyWeb implements HocKy{
	private MonHoc monCn;
	
	public HocKyWeb(MonHoc monCn) {
		super();
		this.monCn = monCn;
	}

	@Override
	public String hocKy() {
		// TODO Auto-generated method stub
		return "Web Fullstack Development\n"+monCn.monHoc();
	}

}
