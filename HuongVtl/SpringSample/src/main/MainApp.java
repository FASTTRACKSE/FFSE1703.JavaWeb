package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import bean.HocKyFE;
import bean.LopHocFE;
import bean.SinhVien;
import bean.TenMonHoc;

public class MainApp {
	private static ClassPathXmlApplicationContext context;

	public static void main(String[] args) {
		  context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		 
		  // Tạo bean từ spring containner
		  SinhVien sinhVien1 = context.getBean("sinhVien", SinhVien.class);
		  sinhVien1.setHoTen("h");
		  sinhVien1.setLopHoc(new LopHocFE("ffse1703"));
		  sinhVien1.setHocKy(new HocKyFE(" 1"));
		  sinhVien1.setMonHoc(new TenMonHoc("môn toán, môn lý", "thầy A dạy"));
		  
		  System.out.println(sinhVien1.inThongTin());
	
	}
}
