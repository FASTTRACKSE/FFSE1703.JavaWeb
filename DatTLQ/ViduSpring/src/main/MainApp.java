package main;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.SinhVien;
import bean.MonHoc;

public class MainApp {
	// Nạp file config spring từ applicationContext.xml
	static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationBean2.xml");
	// Tạo bean từ spring containner
	private static String name;
	private static Scanner scanner = new Scanner(System.in);
	static ArrayList<MonHoc> arrMonHoc= new ArrayList<>();

	public static void main(String[] args) {
		
		myMenu();
		
	}
	public static void myMenu() {
		 SinhVien sinhVien = context.getBean("sinhvien1", SinhVien.class);

		System.out.println("Nhập tên của bạn:");
		name = scanner.nextLine();
		sinhVien.setHoTen(name);
		sinhVien.mangSachDiHoc();
		
	}
}
