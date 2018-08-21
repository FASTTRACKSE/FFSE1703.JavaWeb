package fasttrackse.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.SinhVienVersion4;

public class MainAppSpringV1 {
	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Tạo bean từ spring containner
		SinhVienVersion4 sinhVien1 = context.getBean("sinhvien1", SinhVienVersion4.class);
		SinhVienVersion4 sinhVien2 = context.getBean("sinhvien2", SinhVienVersion4.class);
		
		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());
		
		context.close();
	}
}
