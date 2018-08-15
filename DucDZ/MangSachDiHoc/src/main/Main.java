package main;

import java.util.Scanner;

import bean.SinhVien;

public class Main {
	static String name;
	static String sach;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Nhập Tên :");
		name = sc.nextLine();
		menu(name);
	}

	public static void menu(String name) {
		while (true) {
			System.out.println("1. Học Toán.");
			System.out.println("2. Học Lý.");
			System.out.println("3. Học Hóa.");
			int myChoice = sc.nextInt();
			if (myChoice == 1) {
				sachToan(name);
			}
			if (myChoice == 2) {
				sachLy(name);
			}
			if (myChoice == 3) {
				sachHoa(name);
			}
			if (myChoice > 3) {
				System.out.println("Chỉ nhập từ 1-3");
			}
		}
	}

	private static void sachHoa(String name) {
		SinhVien sv = new SinhVien();
		sach = "";
		System.out.println(sv.mangsachHoa(name, sach));
	}

	private static void sachLy(String name) {
		SinhVien sv = new SinhVien();
		sach = "";
		System.out.println(sv.mangsachLy(name, sach));
	}

	private static void sachToan(String name) {
		SinhVien sv = new SinhVien();
		sach = "";
		System.out.println(sv.mangsachToan(name, sach));
	}

}
