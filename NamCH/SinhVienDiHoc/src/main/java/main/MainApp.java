package main;

import java.util.ArrayList;
import java.util.List;

import entity.DaoTaoDaiHan;
import entity.MonHoc;
import entity.MonLP1;
import entity.MonLP2;
import entity.SinhVien;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinhVien sv1 = new SinhVien("Thành");
		sv1.setHeDaoTao(new DaoTaoDaiHan());
		List<MonHoc> monHoc = new ArrayList<MonHoc>();
		monHoc.add(new MonLP1());
		monHoc.add(new MonLP2());
		sv1.setMonHoc(monHoc);
		System.out.println(sv1.diHoc());
	}

}
