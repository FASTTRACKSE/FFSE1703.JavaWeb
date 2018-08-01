package fasttrackse.entity;

public class SinhVienVersion4 {
	private String hoTen;
	public MonHoc monHoc;
	
	public SinhVienVersion4() {
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

	public SinhVienVersion4(String hoTen) {
		super();
		this.hoTen = hoTen;
	}

	public String mangSachDiHoc() {
		String result = "Bạn " + hoTen + " " + monHoc.mangSachDiHoc();

		return result;
	}

}
