package entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class HocKi3 implements HocKi {
	private List<MonCongNghe> listCongNghe;
	
	
	public HocKi3() {
		
	}

	public List<MonCongNghe> getListCongNghe() {
		return listCongNghe;
	}

	public void setListCongNghe(List<MonCongNghe> listCongNghe) {
		this.listCongNghe = listCongNghe;
	}
	@Override
	public String thongTinHocKi() {
		String kq =  "- Học kì chuyên đề \n - Môn công nghệ : ";
			for(MonCongNghe x:listCongNghe) {
				kq+=x.inforMonHoc();
			}
			
		return kq;
	}
	
}
