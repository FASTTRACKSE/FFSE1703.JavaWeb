package main;

import java.util.Scanner;

import bean.MonHoa;
import bean.MonToan;
import bean.Student;

public class StudentMain {
	public static Scanner myInput=new Scanner(System.in);
	public static Student objMon = new Student();
	public static String ten;
	public static void main(String[] args) {
		myMenu();
		
	}
	public static void myMenu() {
		while (true) {
			System.out.println("Nhập Họ Và Tên Sinh Viên:");
			ten = myInput.nextLine();
			objMon.setHoTen(ten);
			System.out.println("<======LỰA CHỌN MÔN HỌC======>");
			System.out.println("|| 1.Toán                     ");
			System.out.println("|| 2.Lý                       ");
			System.out.println("|| 3.Hóa                      ");
			System.out.println("<===============================>");
			System.out.println("      LỰA CHỌN CỦA BẠN        ");
			int option = Integer.parseInt(myInput.nextLine());
			if (option == 1) {
				toan();
			} else if (option == 2) {
				Ly();
			} else if (option == 3) {
				Hoa();
			} 
                try {
					throw new Exception();
				} catch (Exception e) {
					
				}
			}
		}
	public static void toan() {
		myInput.nextLine();
		objMon.setMonHoc(new MonToan()); 
		objMon.mangSachDiHoc();
	}
	public static void Ly() {
		myInput.nextLine();
		objMon.setMonHoc(new MonHoa());
		objMon.mangSachDiHoc();
		}
	public static void Hoa() {
		myInput.nextLine();
		objMon.setMonHoc(new MonHoa());
		objMon.mangSachDiHoc();
	}
}
