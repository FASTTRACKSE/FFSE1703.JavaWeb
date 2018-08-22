package entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class HocKi2 implements HocKi {
	private List<MonCongNghe> listCongNghe;
	private MonTiengAnh monTiengAnh;
	
	public HocKi2() {
		
	}

	public List<MonCongNghe> getListCongNghe() {
		return listCongNghe;
	}

	public void setListCongNghe(List<MonCongNghe> listCongNghe) {
		this.listCongNghe = listCongNghe;
	}

	public MonTiengAnh getMonTiengAnh() {
		return monTiengAnh;
	}

	public void setMonTiengAnh(MonTiengAnh monTiengAnh) {
		this.monTiengAnh = monTiengAnh;
	}

	@Override
	public String thongTinHocKi() {
		String kq =  "- Học kì 2: \n - Môn công nghệ : ";
			for(MonCongNghe x:listCongNghe) {
				kq+=x.inforMonHoc();
			}
			kq+= "\n -Môn Tiếng anh: \n"+monTiengAnh.inforMonHoc();
		return kq;
	}
	
}
