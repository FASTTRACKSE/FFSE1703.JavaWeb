package controller;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.*;

public class MainApp_v4 {
	public static Scanner myScanner = new Scanner(System.in);
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SinhVien_v3 sv1 = context.getBean("sinhvien1", SinhVien_v3.class);
		SinhVien_v3 sv2 = context.getBean("sinhvien2", SinhVien_v3.class);
		System.out.println(sv1.mangSachDiHoc());
		System.out.println("==========================");
		System.out.println(sv2.mangSachDiHoc());
		context.close();
	}

}
