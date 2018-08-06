package fasttrackse.main;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.DaoTaoNganHan;
import fasttrackse.entity.MonEnglish;
import fasttrackse.entity.MonHoa;
import fasttrackse.entity.MonHoc;
import fasttrackse.entity.MonLy;
import fasttrackse.entity.MonToan;
import fasttrackse.entity.SinhVienVersion1;
 
public class MainApp {
 
       public static void main(String[] args) {
              // Nạp file config spring từ applicationContext.xml
              ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
             
              // Tạo bean từ spring containner
              SinhVienVersion1 sinhVien1 = context.getBean("sinhvien", SinhVienVersion1.class);
              SinhVienVersion1 sinhVien2 = context.getBean("sinhvien", SinhVienVersion1.class);
              
              MonHoa monHoa = context.getBean("monHoa", MonHoa.class);
              MonLy monLy = context.getBean("monLy", MonLy.class);
              MonToan monToan = context.getBean("monToan", MonToan.class);
              MonEnglish monEnglish = context.getBean("monEnglish", MonEnglish.class);
              
              DaoTaoNganHan heDaoTaoNganHan = context.getBean("daoTaoNganHan", DaoTaoNganHan.class);
              
              List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
              monHoc1.add(monToan);
              monHoc1.add(monEnglish);
              monHoc1.add(monLy);
              
              List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
              monHoc2.add(monToan);
              monHoc2.add(monLy);
              
              sinhVien1.setHoTen("T�");
              sinhVien1.setMonHoc(monHoc1);
              
              sinhVien2.setHoTen("Lan");
              sinhVien2.setMonHoc(monHoc2);
              sinhVien2.setHeDaoTao(heDaoTaoNganHan);
              
             
              System.out.println(sinhVien1.mangSachDiHoc());
              System.out.println(sinhVien2.mangSachDiHoc());
              
              context.close();
 
       }
 
}