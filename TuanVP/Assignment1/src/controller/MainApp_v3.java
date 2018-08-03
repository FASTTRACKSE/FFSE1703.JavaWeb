package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import bean.*;

public class MainApp_v3 {
	public static SinhVien_v3 sv;
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Nhập tên sinh viên");
		String name = myScanner.nextLine();
		sv = new SinhVien_v3(name);
		List<MonHoc> monHoc = new ArrayList<MonHoc>();
		monHoc.add(new MonToan());
		monHoc.add(new MonLy());
		monHoc.add(new MonHoa());
		while (true) {
			System.out.println("Chọn hệ đào tạo:");
			System.out.println("1. Đào tạo dài hạn");
			System.out.println("2. Đào tạo ngắn hạn");
			System.out.println("0. Thoát");
			System.out.println("Nhập lựa chọn:");
			int he = myScanner.nextInt();
			if (he == 1) {
				sv.setHeDaoTao(new DaoTaoDaiHan());
				sv.setMonHoc(monHoc);
			} else if (he == 2) {
				sv.setHeDaoTao(new DaoTaoNganHan());
				sv.setMonHoc(monHoc);
			} else if (he == 0) {
				System.exit(0);
			}
			System.out.println("Bạn "+sv.getHoTen()+" :");
			System.out.println(sv.heDaoTao());
//			for (MonHoc mH : monHoc) {
//				System.out.println("- "+mH.mangSachDiHoc());
//			}
			System.out.println(sv.mangSachDiHoc());
			myScanner.nextLine();
			myScanner.nextLine();
		}
	}

}
