package fasttrackse.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.SinhVien;


 
public class MainApp{
 
       public static void main(String[] args) {
              // Nạp file config spring từ applicationContext.xml
              ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
             
              // Tạo bean từ spring containner
              SinhVien sinhVien1 = context.getBean("sinhvien1", SinhVien.class);
      			sinhVien1.setHoTen("Hồ Quang Minh");
      			SinhVien sinhVien2 = context.getBean("sinhvien2", SinhVien.class);
      		
      		System.out.println(sinhVien1.mangSachDiHoc());
      		System.out.println(sinhVien2.mangSachDiHoc());
      		
      		context.close();
 
       }
 
}