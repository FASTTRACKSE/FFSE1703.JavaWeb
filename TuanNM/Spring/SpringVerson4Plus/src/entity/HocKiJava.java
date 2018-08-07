package entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class HocKiJava implements HocKi {
	private List<MonCongNghe> listCongNghe;
	private List<String> ListChuDe;
	
	
	public HocKiJava() {
		
	}

	public List<String> getListChuDe() {
		return ListChuDe;
	}

	public void setListChuDe(List<String> listChuDe) {
		ListChuDe = listChuDe;
	}

	public List<MonCongNghe> getListCongNghe() {
		return listCongNghe;
	}

	public void setListCongNghe(List<MonCongNghe> listCongNghe) {
		this.listCongNghe = listCongNghe;
	}

	@Override
	public String thongTinHocKi() {
		String kq =  "-Java Devalopment \n - Môn công nghệ : ";
			for(MonCongNghe x:listCongNghe) {
				kq+=x.inforMonHoc();
			}
			kq+="\n- Chủ để Java:";
			for(String x:ListChuDe) {
				kq+="\n    -"+x;
			}			
		return kq;
	}
}
