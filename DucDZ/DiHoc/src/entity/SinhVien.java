package entity;

import java.util.List;

import entity.HeDaoTao;
import entity.MonHoc;

public class SinhVien {
	public String hoTen;
	public List<MonHoc> mh;
	public HeDaoTao hdt;

	public SinhVien() {
		super();
	}

	public List<MonHoc> getMh() {
		return mh;
	}

	public void setMh(List<MonHoc> mh) {
		this.mh = mh;
	}

	public HeDaoTao getHdt() {
		return hdt;
	}

	public void setHdt(HeDaoTao hdt) {
		this.hdt = hdt;
	}

	public SinhVien(String hoTen) {
		super();
		this.hoTen = hoTen;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public SinhVien(String hoTen, HeDaoTao hdt) {
		super();
		this.hoTen = hoTen;
		this.hdt = hdt;
	}

	public String mangSach() {
		String result = "Bạn " + hoTen + ": ";
		result += "\n" + hdt.getGioHoc();
		for (MonHoc x : mh) {
			result += "\n\t- " + x.mangSach();
		}
		return result;
	}
}