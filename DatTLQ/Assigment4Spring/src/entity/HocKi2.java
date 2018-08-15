package entity;

import java.util.List;

public class HocKi2 implements HocKi {
	private List<MonCongNghe> listMonCongNghe;
	private MonTiengAnh monTiengAnh;
	
	
	



	public List<MonCongNghe> getListMonCongNghe() {
		return listMonCongNghe;
	}


	public void setListMonCongNghe(List<MonCongNghe> listMonCongNghe) {
		this.listMonCongNghe = listMonCongNghe;
	}


	public MonTiengAnh getMonTiengAnh() {
		return monTiengAnh;
	}


	public void setMonTiengAnh(MonTiengAnh monTiengAnh) {
		this.monTiengAnh = monTiengAnh;
	}


	public String thongTinHocKi() {
		String kq= "- Học Kì 2:\n - Môn Công Nghệ:";
		for (MonCongNghe x:listMonCongNghe) {
			kq+= x.thongTinMonHoc();
		}
		kq += "\n -Môn Tiếng Anh: \n"+ monTiengAnh.thongTinMonHoc();
		return kq;
	}


	public HocKi2() {
	
	}

}
