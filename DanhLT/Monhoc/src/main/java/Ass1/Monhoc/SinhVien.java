package Ass1.Monhoc;

public class SinhVien {
	private String HoTen;

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public void mangSachToanDiHoc() {
		System.out.println("Bạn  "+ HoTen +"   cần mang sách Toán đi học");
	}

	public void mangSachHoaDiHoc() {
		System.out.println("Bạn"  + HoTen + " cần mang sách Hoá đi học");
	}

	public void mangSachLyDiHoc() {
		System.out.println("Bạn"  + HoTen + " cần mang sách Lý đi học");
	}

}
