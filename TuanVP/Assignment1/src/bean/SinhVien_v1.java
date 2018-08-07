package bean;

public class SinhVien_v1 {
	private String hoTen;

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public void mangSachToanDiHoc() {
		System.out.println("Bạn " + hoTen + " hãy mang sách toán đi học");
	}

	public void mangSachLyDiHoc() {
		System.out.println("Bạn " + hoTen + " hãy mang sách lý đi học");
	}

	public void mangSachHoaDiHoc() {
		System.out.println("Bạn " + hoTen + " hãy mang sách hóa đi học");
	}
}
