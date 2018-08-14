package controller;

import java.util.Scanner;

import bean.*;

public class MainApp_v2 {
	public static SinhVien_v2 sv;
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Nhập tên sinh viên");
		String name = myScanner.nextLine();
		sv = new SinhVien_v2(name);
		while (true) {
			System.out.println("Chọn môn học");
			System.out.println("1. Môn toán");
			System.out.println("2. Môn lý");
			System.out.println("3. Môn hóa");
			System.out.println("0. Thoát");
			System.out.println("Nhập lựa chọn:");
			int mon = myScanner.nextInt();
			if (mon == 1) {
				sv.setMonHoc(new MonToan());
			} else if (mon == 2) {
				sv.setMonHoc(new MonLy());
			} else if (mon == 3) {
				sv.setMonHoc(new MonHoa());
			} else if (mon == 0) {
				System.exit(0);
			}
			System.out.println(sv.mangSachDiHoc());
			myScanner.nextLine();
			myScanner.nextLine();
		}
	}

}
