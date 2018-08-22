package entity;

public class HocKi4 implements HocKi {
	private MonThucTap monThucTap;
	
	public MonThucTap getMonThucTap() {
		return monThucTap;
	}

	public void setMonThucTap(MonThucTap monThucTap) {
		this.monThucTap = monThucTap;
	}

	public String thongTinHocKi() {
		String kq= "- Học Kì thực tập ";
		
			kq+= monThucTap.thongTinMonHoc() ;
	
		
		return kq;
	}
}
