package main;

import java.util.ArrayList;
import java.util.List;

import entity.MonHoa;
import entity.MonHoc;
import entity.MonLy;
import entity.MonToan;
import entity.SVVersion2;
import entity.SVVersion3;
import entity.SinhVienVersion1;

public class MainApp {
	public static void main(String[] args) {
		// Version 1
		SinhVienVersion1 sinhVien = new SinhVienVersion1("Thành");
		System.out.println(sinhVien.mangSachToanDiHoc());
		System.out.println(sinhVien.mangSachLyDiHoc());
		System.out.println(sinhVien.mangSachHoaDiHoc());
		// Version 2
		SVVersion2 sv = new SVVersion2("Đạt");
		// môn toán
		MonHoc monHoc = new MonToan();
		sv.setMonHoc(monHoc);
		System.out.println(sv.mangSachDiHoc());
		// môn lý
		sv.setMonHoc(new MonLy());
		System.out.println(sv.mangSachDiHoc());
		// môn hóa
		sv.setMonHoc(new MonHoa());
		System.out.println(sv.mangSachDiHoc());
		// Version 3
		SVVersion3 sv1 = new SVVersion3("Đạt");
		List<MonHoc> listMonHoc= new ArrayList<MonHoc>();
		listMonHoc.add(new MonToan());
		listMonHoc.add(new MonLy());
		sv1.setListMonHoc(listMonHoc);
		System.out.println(sv1.mangSachDiHoc());
	}
}
