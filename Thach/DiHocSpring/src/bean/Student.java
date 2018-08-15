package bean;

import java.util.ArrayList;

public class Student {
	public String hoTen;
	private ArrayList<MonHoc> monHocArr = new ArrayList<>();
	private KhoaHoc khoaHoc;
	
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

	
	public ArrayList<MonHoc> getMonHoc() {
		return monHocArr;
	}

	public KhoaHoc getKhoaHoc() {
		return khoaHoc;
	}

	public void setKhoaHoc(KhoaHoc khoaHoc) {
		this.khoaHoc = khoaHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		monHocArr.add(monHoc);
	}

	public void diHoc() {
		System.out.println("Bạn " + hoTen);
		System.out.println(khoaHoc.chonKhoaHoc());
		for(MonHoc x: monHocArr) {
		System.out.println("   -" + x.mangSachDiHoc());
		}
	}
	
}
