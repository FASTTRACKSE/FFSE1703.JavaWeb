package bean;

public class Student {
	private String hoTen;

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public void MangSachToan() {
		System.out.println("Bạn " +hoTen+ " Hãy mang sách Toán đi học");
	}
	public void MangSachLy() {
		System.out.println("Bạn " +hoTen+ " Hãy mang sách Lý đi học");
	}
	public void MangSachHoa() {
		System.out.println("Bạn " +hoTen+ " Hãy mang sách Hóa đi học");
	}
}
