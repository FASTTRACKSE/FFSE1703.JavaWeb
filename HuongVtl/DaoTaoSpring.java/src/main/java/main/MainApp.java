package main;

import bean.HeDaoTaoNganHan;
import bean.MonLy;
import bean.MonToan;
import bean.SinhVien;

public class MainApp {
	public static void main(String[] args) {
		SinhVien sv = new SinhVien();
		sv.setHoTen("huong");
		sv.setMonHoc(new MonToan());
		System.out.println(sv.mangSachDiHoc());
		
		sv.setMonHoc (new MonLy());
		System.out.println(sv.mangSachDiHoc());
		sv.setHeDaoTao(new HeDaoTaoNganHan());
		System.out.println(sv.heDaoTao());
	}
}
