package main;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.KhoaHocDaiHan;
import bean.KhoaHocNganHan;
import bean.MonHoa;
import bean.MonHoc;
import bean.MonLy;
import bean.MonToan;
import bean.Student;

public class StudentMain {
	public static Scanner myInput = new Scanner(System.in);
	public static Student objMon = new Student();
	public static String ten;
	public ArrayList<MonHoc> arrMonHoc = new ArrayList<>();

	public static void main(String[] args) {
		chonKhoahoc();

	}

	public static void chonKhoahoc() {
		while (true) {
			System.out.println("Nhập Họ Và Tên Sinh Viên:");
			ten = myInput.nextLine();
			objMon.setHoTen(ten);
			System.out.println("<======LỰA CHỌN KHÓA HỌC======>");
			System.out.println("|| 1.Khóa học dài hạn            ");
			System.out.println("|| 2.Khóa học ngắn hạn           ");
			System.out.println("<===============================>");
			System.out.println("      LỰA CHỌN CỦA BẠN        ");
			int option = Integer.parseInt(myInput.nextLine());
			if (option == 1) {
				objMon.setKhoaHoc(new KhoaHocDaiHan());
				myMenu();
			} else {
				objMon.setKhoaHoc(new KhoaHocNganHan());
				myMenu();
			}
			try {
				throw new Exception();
			} catch (Exception e) {

			}
		}
	}

	public static void myMenu() {
		while (true) {

			objMon.setHoTen(ten);
			System.out.println("<======LỰA CHỌN MÔN HỌC======>");
			System.out.println("|| 1.Toán                     ");
			System.out.println("|| 2.Lý                       ");
			System.out.println("|| 3.Hóa                      ");
			System.out.println("|| 4.in                       ");
			System.out.println("<============================>");
			System.out.println("      LỰA CHỌN CỦA BẠN        ");
			int option = myInput.nextInt();
			if (option == 1) {
				objMon.setMonHoc(new MonToan());
			} else if (option == 2) {
				objMon.setMonHoc(new MonLy());
			} else if (option == 3) {
				objMon.setMonHoc(new MonHoa());
			} else {
				in();
			}
			try {
				throw new Exception();
			} catch (Exception e) {

			}
		}
	}

	public static void in() {
		objMon.diHoc();
	}

}
