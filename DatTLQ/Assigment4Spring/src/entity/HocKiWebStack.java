package entity;

import org.springframework.stereotype.Component;

@Component
public class HocKiWebStack implements HocKi {
private MonCongNghe monCongNghe;
	
	public MonCongNghe getMonCongNghe() {
		return monCongNghe;
	}

	public void setMonCongNghe(MonCongNghe monCongNghe) {
		this.monCongNghe = monCongNghe;
	}

	public String thongTinHocKi() {
		String kq= "- Web Fullstack Development :\n - Môn Công Nghệ:";
		
			kq+= monCongNghe.thongTinMonHoc();
		
		
		return kq;
	}

}
