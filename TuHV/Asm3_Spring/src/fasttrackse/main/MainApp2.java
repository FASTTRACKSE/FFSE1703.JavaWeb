package fasttrackse.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.SinhVienVersion2;


public class MainApp2 {

	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

		// Tạo bean từ spring containner
		SinhVienVersion2 sinhvien1 = context.getBean("sinhvien1", SinhVienVersion2.class);
		SinhVienVersion2 sinhvien2 = context.getBean("sinhvien2", SinhVienVersion2.class);

		System.out.println(sinhvien1.mangSachDiHoc());
		System.out.println(sinhvien2.mangSachDiHoc());

		context.close();

	}

}
