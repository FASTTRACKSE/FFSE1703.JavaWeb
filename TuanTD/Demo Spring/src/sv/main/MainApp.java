package sv.main;

import java.util.Scanner;

import sv.model.MonLy;
import sv.model.MonToan;
import sv.model.MonVan;
import sv.model.SinhVien;

public class MainApp {
	private static String name;
	public static Scanner myScanner = new Scanner(System.in);
	static SinhVien sv = new SinhVien();

	public static void main(String[] args) {
		nhapName();
	}

	public static void nhapName() {
		while (true) {
			System.out.print("Nhập vào tên của bạn : ");
			name = myScanner.nextLine();
			sv.setHoTen(name);
			if (name.isEmpty()) {
				System.out.println("Vui lòng nhập tên");
			} else {
				listSubject();
				
			}
			myScanner.nextLine();
			myScanner.nextLine();
		}
	}

	public static void listSubject() {
		System.out.println("+------BẠN MUỐN HỌC MÔN GÌ-----+");
		System.out.println("| 1.TOÁN                      |");
		System.out.println("| 2.LÍ                         |");
		System.out.println("| 3.SINH                       |");
		System.out.println("| 4.Nhập lại Tên               |");
		System.out.println("================================");

		int option = myScanner.nextInt();
		if (option == 1) {
			sv.setMonHoc(new MonToan());
			sv.mangSachDiHoc();
		} else if (option == 2) {
			sv.setMonHoc(new MonLy());
			sv.mangSachDiHoc();
		} else if (option == 3) {
			sv.setMonHoc(new MonVan());
			sv.mangSachDiHoc();
		} else if (option == 4) {
			nhapName();
		}

	}

}
