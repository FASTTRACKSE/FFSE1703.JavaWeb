package fasttrackse.entity;

public class SinhVien {
	private String hoTen;
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public SinhVien(String hoTen) {
		super();
		this.hoTen = hoTen;
	}
	
	public String mangSachToanDiHoc() {
		return "Bạn " + hoTen + " mang sách TOÁN đi học!";
	}
	
	public String mangSachLyDiHoc() {
		return "Bạn " + hoTen + " mang sách LÝ đi học!";
	}
	
	public String mangSachHoaDiHoc() {
		return "Bạn " + hoTen + " mang sách HOÁ đi học!";
	}

	public String mangSachTiengAnhDiHoc() {
		return "Bạn " + hoTen + " mang sách ENGLISH đi học!";
	}
}