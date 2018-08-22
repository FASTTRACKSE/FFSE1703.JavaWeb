package fasttrackse.entity;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class HocKiWebFullStack implements HocKi {
	private List<MonCongNghe> listCongNghe;
	private List<String> ListChuDe;
	
	
	public HocKiWebFullStack() {
		
	}

	
	public List<MonCongNghe> getListCongNghe() {
		return listCongNghe;
	}


	public void setListCongNghe(List<MonCongNghe> listCongNghe) {
		this.listCongNghe = listCongNghe;
	}


	public List<String> getListChuDe() {
		return ListChuDe;
	}


	public void setListChuDe(List<String> listChuDe) {
		ListChuDe = listChuDe;
	}


	@Override
	public String thongTinHocKi() {
		String result =  "-  Web Fullstack Development: \n - Môn công nghệ : ";
			for(MonCongNghe x:listCongNghe) {
				result+="\n - "+x.chonMonHoc();
			}
			result+="- Chủ để Java:";
			for(String x:ListChuDe) {
				result+="\n - "+x;
			}			
		return result;
	}
	
}