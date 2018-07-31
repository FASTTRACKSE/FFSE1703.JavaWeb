package fasttrackse.main;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import fasttrackse.entity.SinhVien;

public class MainApp {
	public static Scanner myScanner = new Scanner(System.in);
	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		// Tạo bean từ spring containner
		SinhVien sinhVien1 = context.getBean("sinhvien1", SinhVien.class);
		System.out.println("Nhập tên sinh viên: ");
		String Name = myScanner.nextLine();
		sinhVien1.setHoTen(Name);
		SinhVien sinhVien2 = context.getBean("sinhvien2", SinhVien.class);
		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());

		context.close();

	}

}