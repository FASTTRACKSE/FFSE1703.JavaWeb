package controller;

import java.util.Scanner;

import bean.SinhVien_v1;

public class MainApp_v1 {
	private static Scanner myScanner = new Scanner(System.in);
	private static SinhVien_v1 sv = new SinhVien_v1();
	public static void main(String[] args) {
		nhapHoTen();
	}
	public static void nhapHoTen() {
		System.out.println("Nhập tên học sinh: ");
		String name = myScanner.nextLine();
		sv.setHoTen(name);
		chonMonHoc();
	}
	public static void chonMonHoc() {
		while (true) {
			System.out.println("Chọn môn học");
			System.out.println("1. Môn toán");
			System.out.println("2. Môn lý");
			System.out.println("3. Môn hóa");
			System.out.println("0. Thoát");
			System.out.println("Nhập lựa chọn:");
			int mon = myScanner.nextInt();
			if (mon == 1) {
				sv.mangSachToanDiHoc();
			} else if (mon == 2) {
				sv.mangSachLyDiHoc();
			} else if(mon == 3) {
				sv.mangSachHoaDiHoc();
			} else if (mon == 0) {
				System.exit(0);
			}
			myScanner.nextLine();
			myScanner.nextLine();
		}
	}

}
