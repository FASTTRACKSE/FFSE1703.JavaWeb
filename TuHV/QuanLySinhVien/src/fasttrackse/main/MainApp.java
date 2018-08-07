package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.*;


public class MainApp {
	  public static void main(String[] args) {
          // Náº¡p file config spring tá»« applicationContext.xml
          ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
          
          LopHoc lopHoc = context.getBean("lopHoc", LopHoc.class);
          LopHoc lopHoc1 = context.getBean("lopHoc", LopHoc.class);
         
          
          MonJavaCore monJavaCore = context.getBean("monJavaCore", MonJavaCore.class);
          MonJavaWeb monJavaWeb = context.getBean("monJavaWeb", MonJavaWeb.class);
          MonHTML5 monHTML5 = context.getBean("monHTML5", MonHTML5.class);
          MonMysql monMysql = context.getBean("monMysql", MonMysql.class);
          
          HocKy1 hocKy1 = context.getBean("hocKy1", HocKy1.class);
          HocKy2 hocKy2 = context.getBean("hocKy2", HocKy2.class);
          
          DaoTaoDaiHan daoTaoDaiHan = context.getBean("daoTaoDaiHan", DaoTaoDaiHan.class);
          DaoTaoNganHan daoTaoNganHan = context.getBean("daoTaoNganHan", DaoTaoNganHan.class);
          
          //SV1
          List<SinhVien> sinhvien = new ArrayList<SinhVien>();
          sinhvien.add(new SinhVien("Hồ Viết Tú"));
          sinhvien.add(new SinhVien("Hồ Viết Tú"));
          sinhvien.add(new SinhVien("Hồ Viết Tú"));
          sinhvien.add(new SinhVien("Hồ Viết Tú"));
          sinhvien.add(new SinhVien("Hồ Viết Tú"));
          
          
          
          List<MonHoc> monhoc = new ArrayList<MonHoc>();
          monhoc.add(monJavaCore);
          monhoc.add(monJavaWeb);
          monhoc.add(monMysql);
          monhoc.add(monHTML5);
          
          
          lopHoc.setLopHoc("FFSE1701");
          lopHoc.setHeDaoTao(daoTaoDaiHan);
          lopHoc.setHocKy(hocKy1);
          lopHoc.setMonHoc(monhoc);
          lopHoc.setSinhVien(sinhvien);
          
          //SV2
          List<SinhVien> sinhvien1 = new ArrayList<SinhVien>();
          sinhvien1.add(new SinhVien("Lê Thị Thu Lan"));
          sinhvien1.add(new SinhVien("Lê Thị Thu Lan"));
          sinhvien1.add(new SinhVien("Lê Thị Thu Lan"));
          sinhvien1.add(new SinhVien("Lê Thị Thu Lan"));
          sinhvien1.add(new SinhVien("Lê Thị Thu Lan"));
          
          
          
          List<MonHoc> monhoc1 = new ArrayList<MonHoc>();
          monhoc1.add(monJavaCore);
          monhoc1.add(monJavaWeb);
          monhoc1.add(monMysql);
          monhoc1.add(monHTML5);
          
          
          lopHoc1.setLopHoc("FFSE1701");
          lopHoc1.setHeDaoTao(daoTaoDaiHan);
          lopHoc1.setHocKy(hocKy1);
          lopHoc1.setMonHoc(monhoc1);
          lopHoc1.setSinhVien(sinhvien1);
          
          
          
          
          
          
       
          
         
          System.out.println(lopHoc.getLayDanhSach());
          System.out.println(lopHoc1.getLayDanhSach());
       
          
          context.close();

       
   }
}
