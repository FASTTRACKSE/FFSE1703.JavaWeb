package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import emtity.SinhVien;

public class MainApp {

	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		SinhVien sinhVien1 = context.getBean("sinhvien1", SinhVien.class);
		
		System.out.println(sinhVien1.mangSachDiHoc());
	}

}