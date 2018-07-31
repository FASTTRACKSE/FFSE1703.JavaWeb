package fasttrackse.main;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.SinhVienVersion5;

public class MainAppV5 {
	public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext1.xml");
		
		// Tạo bean từ spring containner
		SinhVienVersion5 sinhVien1 = context.getBean("sinhvien1", SinhVienVersion5.class);
		SinhVienVersion5 sinhVien2 = context.getBean("sinhvien2", SinhVienVersion5.class);
		
		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());
		
		context.close();
	}

}
