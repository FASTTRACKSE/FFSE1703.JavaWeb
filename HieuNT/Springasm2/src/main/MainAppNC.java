package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import emtity.SinhVienNangCao;

public class MainAppNC {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext1.xml");

		// Tạo bean từ spring containner
		SinhVienNangCao sinhVien1 = context.getBean("sinhvien1", SinhVienNangCao.class);

		System.out.println(sinhVien1.mangSachDiHoc());

		context.close();
	}

}
