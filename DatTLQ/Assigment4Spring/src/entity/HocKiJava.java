package entity;

public class HocKiJava implements HocKi {
	private MonCongNghe monCongNghe;
	
	public MonCongNghe getMonCongNghe() {
		return monCongNghe;
	}

	public void setMonCongNghe(MonCongNghe monCongNghe) {
		this.monCongNghe = monCongNghe;
	}

	public String thongTinHocKi() {
		String kq= "- Java Development :\n - Môn Công Nghệ:";
		
			kq+= monCongNghe.thongTinMonHoc();
		
		
		return kq;
	}

}
