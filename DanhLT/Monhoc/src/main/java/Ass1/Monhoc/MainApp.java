package Ass1.Monhoc;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
	public static Scanner input = new Scanner(System.in);
	static ArrayList<SinhVien> arrBienLai = new ArrayList<SinhVien>();
	static SinhVien a = new SinhVien();

	public static void main(String[] args) {
		a = new SinhVien();
		System.out.println("Nhập Tên Sinh Vien :");
		String ten = input.nextLine();
		a.setHoTen(ten);
		ChonMon();
	}

	public static void ChonMon() {
		// TODO Auto-generated method stub
		{
			System.out.println(">>               Chọn Môn Học           <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Toán                                 |");
			System.out.println("|2. Lý                                   |");
			System.out.println("|3. Hóa                                  |");
			System.out.println("|4. Kết Thúc                             |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            chọn chức năng.         <<");
			int myOption = input.nextInt();
			if (myOption == 1) {
				Toan();
			} else if (myOption == 2) {
				Ly();
			} else if (myOption == 3) {
				Hoa();
			} else if (myOption == 4) {
				ketThuc();
			}
		}
	}

	public static void Toan() {

		a.mangSachToanDiHoc();
	}

	public static void Ly() {

		a.mangSachLyDiHoc();
	}

	public static void Hoa() {
		a.mangSachHoaDiHoc();
	}

	public static void ketThuc() {
		System.out.println("ket thuc!!!!!");
		System.exit(0);
	}

}
