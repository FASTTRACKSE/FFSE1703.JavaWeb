package FFSE;

public class HeDaoTaoNganHan implements HeDaoTao{
	public HocKi hocKi;

	public HeDaoTaoNganHan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeDaoTaoNganHan(HocKi hocKi) {
		super();
		this.hocKi = hocKi;
	}

	@Override
	public String getGioHoc() {
		return "6 tháng, từ 18h30-21h30";
	}

	@Override
	public String getHeDaoTao() {
		String st = " Học trong " + getGioHoc() + "\n\n";
		st += " "+hocKi.getHocKi() + "\n";
		return st;
	}


}
