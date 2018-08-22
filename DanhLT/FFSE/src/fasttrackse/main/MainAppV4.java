package fasttrackse.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.SinhVienVersion4;

public class MainAppV4 {

	public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// Tạo bean từ spring containner
		SinhVienVersion4 sinhVien1 = context.getBean("sinhvien1", SinhVienVersion4.class);
		SinhVienVersion4 sinhVien2 = context.getBean("sinhvien2", SinhVienVersion4.class);
		
		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());
		
		context.close();

	}

}
