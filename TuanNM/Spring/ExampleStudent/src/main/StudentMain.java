package main;

import java.util.ArrayList;
import java.util.Scanner;

import bean.Student;

public class StudentMain {
	private static String name;
	public static Scanner myScanner = new Scanner(System.in);
	static Student st = new Student();

	public static void main(String[] args) {
		nhapName();
	}

	public static void nhapName() {
		while (true) {
			System.out.print("Nhập vào tên của bạn : ");
			name = myScanner.nextLine();
			st.setHoTen(name);
			if (name.isEmpty()) {
				System.out.println("Vui lòng nhập tên");
			} else {
				listSubject();
			}
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
				st.setMangToan();
				nhapLai();
			} else if (option == 2) {
				st.setMangToan();
				nhapLai();
			} else if (option == 3) {
				st.setMangToan();
				nhapLai();
			} else if (option == 4) {
				nhapName();
			}		
	}
	public static void nhapLai() {
		
		System.out.println("Nhấn Enter để tiếp tục");
		myScanner.nextInt();
		nhapName();	
	}
}
