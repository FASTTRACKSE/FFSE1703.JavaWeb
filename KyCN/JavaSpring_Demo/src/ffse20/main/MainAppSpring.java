package ffse20.main;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ffse20.entity.*;

public class MainAppSpring {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// Tạo bean từ spring containner
		SinhVienSpring sinhVien1 = context.getBean("sinhvien1", SinhVienSpring.class);
		System.out.println("Nhập Tên Sinh Vien :");
		String ten = input.nextLine();
		sinhVien1.setHoTen(ten);		
		System.out.println(sinhVien1.mangSachDiHoc());

		
		context.close();
	}

}
