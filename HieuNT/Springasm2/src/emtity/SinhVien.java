package emtity;

public class SinhVien {
	private String hoTen;
	public MonHoc monHoc;	
	public SinhVien() {
		super();
	}

	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
	
	public SinhVien(String hoTen) {
		super();
		this.hoTen = hoTen;
	}
	
	public String mangSachDiHoc() {
		String result ="Bạn " + hoTen + " " + monHoc.mangSachDiHoc();
		return result;
	}

	
}
