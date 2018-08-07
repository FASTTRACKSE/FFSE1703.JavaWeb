package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.DaoTaoDaiHan;
import entity.DaoTaoNganHan;
import entity.HocKiSV;
import entity.Lop;
import entity.MonHoc;
import entity.SinhVien;
import entity.Subjects;

public class MainApp {
	public static void main(String[] args) {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		 Lop lop=context.getBean("lop", Lop.class);
		 Lop lop2=context.getBean("lop", Lop.class);
		 DaoTaoDaiHan daiHan=context.getBean("daoTaoDaiHan", DaoTaoDaiHan.class);
		 DaoTaoNganHan nganHan=context.getBean("daoTaoNganHan", DaoTaoNganHan.class);
		 List<MonHoc> listMonHoc= new ArrayList<>();
		 listMonHoc.add(new Subjects("Toán"));
		 List<MonHoc> listMonHoc2= new ArrayList<>();

		 listMonHoc2.add(new Subjects("Sinh"));
		 List<SinhVien> listSV= new ArrayList<>();
		 listSV.add(new SinhVien("Đạt"));
		 List<SinhVien> listSV2= new ArrayList<>();

		 listSV2.add(new SinhVien("Nhân"));
		 
		 lop.setSinhVien(listSV);
		 lop.setHeDaoTao(nganHan);
		 lop.setHocKi(new HocKiSV("Học Kì I"));
		 lop.setMonHoc(listMonHoc);
		 lop.setLop("FFSE1703");
		 lop.diHoc();
		 
		 lop2.setSinhVien(listSV2);
		 lop2.setHeDaoTao(daiHan);
		 lop2.setHocKi(new HocKiSV("Học Kì II"));
		 lop2.setMonHoc(listMonHoc2);
		 lop2.setLop("FFSE1802");
		 lop2.diHoc();
		 
	}
}
