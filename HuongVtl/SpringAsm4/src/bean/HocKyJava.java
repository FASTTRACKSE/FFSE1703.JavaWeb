package bean;

public class HocKyJava implements HocKy{
	private MonHoc monCn;
	
	public HocKyJava(MonHoc monCn) {
		super();
		this.monCn = monCn;
	}

	@Override
	public String hocKy() {
		// TODO Auto-generated method stub
		return " Java Development\n"+monCn.monHoc();
	}

}
