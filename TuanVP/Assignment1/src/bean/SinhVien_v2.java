package bean;

public class SinhVien_v2 {
	private String hoTen;
	private MonHoc monHoc;
	
	public SinhVien_v2() {
		super();
	}
	
	public SinhVien_v2(String ten) {
		super();
		this.hoTen = ten;
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
	public String mangSachDiHoc() {
		return "Bạn "+hoTen+" "+monHoc.mangSachDiHoc();
	}
}
