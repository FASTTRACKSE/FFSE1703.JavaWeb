package entity;

import org.springframework.stereotype.Component;

@Component
public class HeNganHan implements HeDaoTao{
	private HocKi hocKi;
	
	public HeNganHan() {
		
	}
	public HocKi getHocKi() {
		return hocKi;
	}
	public void setHocKi(HocKi hocKi) {
		this.hocKi = hocKi;
	}
	@Override
	public String hocKi() {
		return "Trong vòng 6 tháng, bạn đi học từ 18h00 đến 21h30 \n"
				+hocKi.thongTinHocKi();
	}

}
