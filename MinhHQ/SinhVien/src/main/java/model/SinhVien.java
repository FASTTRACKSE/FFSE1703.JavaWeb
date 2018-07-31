package model;

public class SinhVien {
	private String hoTen;
	private MonHoc monHoc;
	
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String name) {
		hoTen = name;
	}
	
	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public String mangSachDiHoc() {
		return "Bạn " + hoTen + " " + monHoc.mangSachDiHoc();
	}
}
