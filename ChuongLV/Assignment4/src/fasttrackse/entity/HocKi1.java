package fasttrackse.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class HocKi1 implements HocKi {
	private List<MonCongNghe> listCongNghe;
	private MonEnglish monEnglish;	
	public HocKi1() {
		
	}
	public List<MonCongNghe> getListCongNghe() {
		return listCongNghe;
	}

	public void setListCongNghe(List<MonCongNghe> listCongNghe) {
		this.listCongNghe = listCongNghe;
	}

	public MonEnglish getMonEnglish() {
		return monEnglish;
	}

	public void setMonEnglish(MonEnglish monEnglish) {
		this.monEnglish = monEnglish;
	}

	@Override
	public String thongTinHocKi() {
		String result =  "- Học kì 1: \n - Môn công nghệ : ";
			for(MonCongNghe x:listCongNghe) {
				result+=x.chonMonHoc();
			}
			result+= "\n -Môn Tiếng anh: \n"+monEnglish.chonMonHoc();
		return result;
	}
	
}