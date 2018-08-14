package entity;

public class HeNganHan implements HeDaoTao {
	
	private HocKi hocKi;
	
	public HeNganHan() {
		// 
	}
	
	public HeNganHan(HocKi hocKi) {
		this.hocKi = hocKi;
	}

	@Override
	public String heDaoTao() {
		return "Thông tin thời gian học – giờ đi học (6 tháng, từ 18h30 – 21h30) \n" + hocKi.hocKi() + " \n";
	}

}
