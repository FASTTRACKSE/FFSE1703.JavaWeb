package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao {
	private List<HocKi> listHK;

	public List<HocKi> getListHK() {
	return listHK;
}

public void setListHK(List<HocKi> listHK) {
	this.listHK = listHK;
}
	@Override
	public String chonKhoaHoc() {
		// TODO Auto-generated method stub
		String kq="Thông tin thời gian học – giờ đi học (6 tháng, từ 18h30 – 21h30)";
		for(HocKi x: listHK) {
			kq+= "\n"+ x.thongTinHocKi();
		}
		return kq;
	}

}
