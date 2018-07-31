package entity;

public class SVVersion2 {
	private String hoTen;
	public MonHoc monHoc;

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

	public SVVersion2(String hoTen) {
		super();
		this.hoTen = hoTen;
	}
	public String mangSachDiHoc() {
		return "Bạn " + hoTen + " " + monHoc.mangSachDiHoc();
	}
}
