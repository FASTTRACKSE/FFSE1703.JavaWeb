package bean;

public class Student {
	private String hoTen;
	

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public void setMangToan() {
		System.out.println("Bạn "+hoTen+" hãy mang sách Toán đi học");
	}
	public void setMangLy() {
		System.out.println("Bạn "+hoTen+" hãy mang sách Lý đi học");
	}
	public void setMangSinh() {
		System.out.println("Bạn "+hoTen+" hãy mang sách Sinh đi học");
	}

}
