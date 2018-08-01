package vn.sinhvien.main;

import java.util.Scanner;

import vn.sinhvien.model.SinhVien;

public class MainApp {
	public static Scanner input = new Scanner(System.in);
	public static SinhVien[] sv = new SinhVien[100];
	public static int n = 0;
	public static String action;

	public static void main(String[] args) {
		myMenu();
	}

	// nhập số sinh viên
	public static void addSv() {
		System.out.println("THÊM SINH VIÊN VÀO DANH SÁCH");
		System.out.println("============================");
		System.out.println("Bạn muốn nhập bao nhiêu sinh viên:");
		n = input.nextInt();
		for (int z = 0; z < n; z++) {
			input.nextLine();
			System.out.println("Nhập Tên Sinh Viên Thứ  " + (z + 1) + " : ");
			String hoTen = input.nextLine();
			sv[z] = new SinhVien(hoTen);
		}
		action = input.nextLine();
		System.out.println("=====================================");
		System.out.println("-------Nhập ENTER để tiếp tục------");
		action = input.nextLine();

	}
	public static void endSv() {
		System.out.println("Kết thúc chương trình");
		System.out.println("======================");
		System.out.println("=======Tkank you======");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("         ____________________________");
			System.out.println("         |==========================|");
			System.out.println("         |----CHỌN LỰA CHỨC NĂNG----|");
			System.out.println("         |--------------------------|");
			System.out.println("         |--1.Nhập danh sinh viên---|");
			System.out.println("         |==========================|");
			System.out.println("         |--2.Kết thúc chương trình-|");
			System.out.println("         |__________________________|");
			System.out.print(" Nhập chức năng mà bạn muốn thực hiện :");
			int act = input.nextInt();
			if (act == 1) {
				addSv();
			} else if(act == 2){
				
			} else {
				endSv();
			}
		}
	}

}
