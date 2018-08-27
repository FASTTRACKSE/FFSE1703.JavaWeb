package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.SinhVien;

public class MainSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");         
         // Tạo bean từ spring containner
         SinhVien sinhVien1 = context.getBean("sinhVien", SinhVien.class);
//         System.out.println(sinhVien1.diHoc());
	}

}
