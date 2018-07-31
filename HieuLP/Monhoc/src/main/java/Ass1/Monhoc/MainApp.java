package Ass1.Monhoc;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
	public static Scanner input = new Scanner(System.in);
	static ArrayList<SinhVien> arrBienLai = new ArrayList<SinhVien>();
	static SinhVien a = new SinhVien();

	public static void main(String[] args) {
		a = new SinhVien();
		System.out.println("Nhập Tên Sinh Viên :");
		String ten = input.nextLine();
		a.setHoTen(ten);
		ChonMon();
	}

	public static void ChonMon() {
		while (true) {
			System.out.println("        ___________________________________");
			System.out.println("         |----Hôm nay bạn học môn gì ?---|");
			System.out.println("         |=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=|");
			System.out.println("         |  1.Môn Toán                   |");
			System.out.println("         |  2.Môn Lý                     |");
			System.out.println("         |  3.Môn Hóa                    |");
			System.out.println("         |                               |");
			System.out.println("         |=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=|");
			System.out.println("         |--4.Kết thúc chương trình------|");
			System.out.println("         |_______________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
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
			input.nextLine();
			System.out.println("     =====================================");
			System.out.println("        -----Nhập ENTER để tiếp tục-----");
			input.nextLine();
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
