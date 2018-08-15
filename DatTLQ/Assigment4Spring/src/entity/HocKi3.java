package entity;

import java.util.List;

public class HocKi3 implements HocKi {

	private List<MonCongNghe> listMonCongNghe;
	
	
	
	



	public List<MonCongNghe> getListMonCongNghe() {
		return listMonCongNghe;
	}


	public void setListMonCongNghe(List<MonCongNghe> listMonCongNghe) {
		this.listMonCongNghe = listMonCongNghe;
	}





	public String thongTinHocKi() {
		String kq= "- Học Kì chuyên đề :\n - Môn Công Nghệ:";
		for (MonCongNghe x:listMonCongNghe) {
			kq+= x.thongTinMonHoc();
		}
		
		return kq;
	}

}
