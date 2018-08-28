package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.DaoTaoDaiHan;
import entity.HocKy;
import entity.HocKySV;
import entity.LopHoc;
import entity.MonHoc;
import entity.MonHocSV;
import entity.SinhVien;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");         
        // Tạo bean từ spring containner
		
        SinhVien sinhVien1 = context.getBean("sinhVien", SinhVien.class);
        sinhVien1.setTenSv("Nam");
        sinhVien1.setLop(new LopHoc("FFSE1703"));
        sinhVien1.setHocKy(new HocKySV("Học Kỳ 1"));
        sinhVien1.setMonHoc(new MonHocSV("LP1", "Thành"));
		sinhVien1.inThongTin();
		
		SinhVien sinhVien2 = context.getBean("sinhVien", SinhVien.class);
        sinhVien2.setTenSv("Quý");
        sinhVien2.setLop(new LopHoc("FFSE1802"));
        sinhVien2.setHocKy(new HocKySV("Học Kỳ 1"));
        sinhVien2.setMonHoc(new MonHocSV("LP2", "Lâm"));
		sinhVien2.inThongTin();
		
		
	}

}
