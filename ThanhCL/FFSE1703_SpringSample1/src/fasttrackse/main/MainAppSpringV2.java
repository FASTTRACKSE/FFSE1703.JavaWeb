package fasttrackse.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.SinhVienVersion5;

public class MainAppSpringV2 {

	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		// Tạo bean từ spring containner
		SinhVienVersion5 sinhVien1 = context.getBean("sinhvien1", SinhVienVersion5.class);
		sinhVien1.setHoTen("Thành Cao Lê");
		SinhVienVersion5 sinhVien2 = context.getBean("sinhvien2", SinhVienVersion5.class);
		
		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());
		
		context.close();
	}

}
