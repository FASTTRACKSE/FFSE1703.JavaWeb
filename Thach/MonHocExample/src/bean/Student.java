package bean;

public class Student {
	public String hoTen;
	public MonHoc monHoc;
	
	public Student() {
		//
	}
	
	public Student(String hoTen) {
		this.hoTen = hoTen;
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
	public void mangSachDiHoc() {
		System.out.println(hoTen + monHoc.mangSachDiHoc());
	}
}
