package fasttrackse.main;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import fasttrackse.entity.*;
 
public class MainApp {
 
       public static void main(String[] args) {
              // Nạp file config spring từ applicationContext.xml
              ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
             
              // Tạo bean từ spring containner
              SinhVienVersion1 sinhVien1 = context.getBean("sinhvien1", SinhVienVersion1.class);
              SinhVienVersion1 sinhVien2 = context.getBean("sinhvien2", SinhVienVersion1.class);
             
              System.out.println(sinhVien1.mangSachDiHoc());
              System.out.println(sinhVien2.mangSachDiHoc());
              
              context.close();
 
       }
 
}