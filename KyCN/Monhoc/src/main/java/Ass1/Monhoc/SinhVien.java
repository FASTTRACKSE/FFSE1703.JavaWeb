package Ass1.Monhoc;
import Ass1.Main.*;
public class SinhVien {
	private String HoTen;
	private MonHoc monHoc;

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}


	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public String mangSachDiHoc() {
		return "Bạn " + HoTen +  monHoc.mangSachDiHoc();
	}

}
