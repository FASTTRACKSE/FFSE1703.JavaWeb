package entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class HeDaiHan implements HeDaoTao {
	private List<HocKi> listHK;
	
	public HeDaiHan() {		
	}
	public List<HocKi> getListHK() {
		return listHK;
	}

	public void setListHK(List<HocKi> listHK) {
		this.listHK = listHK;
	}
	@Override
	public String hocKi() {
		String kq=  "Trong vòng 16 tháng,mời bạn đi học từ 8h30 ,chiều 13h30";
		for(HocKi x:listHK) {
			kq+= "\n"+x.thongTinHocKi();
		}
		return kq;
	}
}
