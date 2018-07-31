package entity;

import java.util.List;

public class SVVersion3 {
	private String hoTen;

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public List<MonHoc> getListMonHoc() {
		return listMonHoc;
	}

	public void setListMonHoc(List<MonHoc> listMonHoc) {
		this.listMonHoc = listMonHoc;
	}

	public List<MonHoc> listMonHoc;

	public SVVersion3(String hoTen) {
		super();
		this.hoTen = hoTen;
	}

	public String mangSachDiHoc() {
		String rs = "";
		for (MonHoc monHoc : listMonHoc) {
			rs = rs + "Bạn " + hoTen + " " + monHoc.mangSachDiHoc();
		}
		return rs;
	}
}
