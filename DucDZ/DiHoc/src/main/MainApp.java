package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.SinhVien;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new 
			ClassPathXmlApplicationContext("appContext.xml");
		// Tạo bean từ spring containner
		SinhVien sinhVien1 = context.getBean("sinhvien1", SinhVien.class);
		sinhVien1.setHoTen("Thành Cao Lê");
		SinhVien sinhVien2 = context.getBean("sinhvien2", SinhVien.class);
		System.out.println(sinhVien1.mangSach());
		System.out.println(sinhVien2.mangSach());
		context.close();
	}

}
