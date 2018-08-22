package fasttrackse.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class DaoTaoNganHan implements HeDaoTao {
	private HocKi listHK;
	
	public DaoTaoNganHan(HocKi listHK) {
		super();
		this.listHK = listHK;
	}



	public HocKi getListHK() {
		return listHK;
	}



	public void setListHK(HocKi listHK) {
		this.listHK = listHK;
	}



	public String hocKi() {
		String result=  "Trong vòng 6 tháng, mời bạn đi học buổi tối từ 18h30 đến 21h30"
		
	+	listHK.thongTinHocKi();
		
		return result;
	
}

}