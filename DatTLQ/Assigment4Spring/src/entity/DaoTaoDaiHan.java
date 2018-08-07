package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoDaiHan implements HeDaoTao {
private List<HocKi> listHK;

	public List<HocKi> getListHK() {
	return listHK;
}

public void setListHK(List<HocKi> listHK) {
	this.listHK = listHK;
}

	public String chonKhoaHoc() {
		// TODO Auto-generated method stub
	String	kq="Thông tin thời gian học – giờ đi học (16 tháng, sáng 8h30, chiều 13h30)";
	 for(HocKi x: listHK) {
		kq+= "\n"+ x.thongTinHocKi();
	}
		return kq;
	}

}
