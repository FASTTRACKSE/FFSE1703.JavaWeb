package main;

import java.util.Scanner;

import emtity.*;

public class MainApp {
	static String fullname1;
	static int END;


	public static void main(String[] args) {
		meNu();

		/*
		 * // NHẮC BẠN MANG SÁCH TOÁN ĐI HỌC // Inject môn Toán cho đối tượng sinhVien
		 * qua phương thức setter setMonHoc
		 * System.out.println(sinhVien.mangSachDiHoc());
		 * 
		 * // NHẮC BẠN MANG SÁCH LÝ ĐI HỌC // Inject môn Lý cho đối tượng sinhVien qua
		 * phương thức setter setMonHoc sinhVien.setMonHoc(new MonLy());
		 * System.out.println(sinhVien.mangSachDiHoc());
		 * 
		 * // NHẮC BẠN MANG SÁCH HOÁ ĐI HỌC // Inject môn Hoá cho đối tượng sinhVien qua
		 * phương thức setter setMonHoc sinhVien.setMonHoc(new MonHoa());
		 * System.out.println(sinhVien.mangSachDiHoc());
		 */

	}

	@SuppressWarnings("resource")
	public static void nhapTen() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào họ và tên  : ");
		fullname1 = input.nextLine();

	}

	public static void meNu() {
		for (int i = 1; i <= 1000; i++) {

			nhapTen();
			SinhVien obj = new SinhVien(fullname1);
			obj.setMonHoc(new MonToan());
			obj.setMonHoc(new MonLy());
			obj.setMonHoc(new MonHoa());
			int chon;
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("*****Chao mung ban den voi chuong trinh chon mon hoc*****");
			System.out.println("1. TOAN");
			System.out.println("2. LY");
			System.out.println("3. HOA ");
			System.out.println("4. END ");


			System.out.println("Lua chon =");
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				System.out.println(obj.mangSachDiHoc());
				break;
			case 2:
				System.out.println(obj.mangSachDiHoc());
				break;
			case 3:
				System.out.println(obj.mangSachDiHoc());
				break;
			case 4:
				System.out.println("KẾT THÚC");
				System.exit(0);
				break;

			default:
				System.out.println("Ban nhap lua chon chua dung");
			}

		}
	}
}
