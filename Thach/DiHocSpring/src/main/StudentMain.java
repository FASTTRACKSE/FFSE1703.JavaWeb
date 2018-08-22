package main;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import bean.Student;

public class StudentMain {
	public static Scanner myInput = new Scanner(System.in);
	public static Student objMon = new Student();
	public static String ten;

	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		myMenu();

	}

	public static void myMenu() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Student student = context.getBean("monHoc", Student.class);
		System.out.println("Nhập Họ Và Tên Sinh Viên:");
		ten = myInput.nextLine();
		student.setHoTen(ten);
		student.diHoc();
	}
}
