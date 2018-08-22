package bean;

public class SinhVien {
	String hoTen;
	public String mangsachToan(String name,String sach) {
		sach = "Toán";
		return ("Bạn "+name+" mang sách "+sach+" đi học !");
	}
	public String mangsachLy(String name, String sach) {
		sach = "Lý";
		return ("Bạn "+name+" mang sách "+sach+" đi học !");
	}
	public String mangsachHoa(String name, String sach) {
		sach = "Hoá";
		return ("Bạn "+name+" mang sách "+sach+" đi học !");
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
}
