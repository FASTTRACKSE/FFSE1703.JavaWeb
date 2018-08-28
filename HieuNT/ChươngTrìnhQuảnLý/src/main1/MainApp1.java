package main1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.LopHoc;
import entity.MonHoc;
import entity.SinhVien;

public class MainApp1 {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext1.xml");
		
		LopHoc lopffse = context.getBean("lopHoc", LopHoc.class);
		//khoi tao ds sv
		List<SinhVien> sv = new ArrayList<SinhVien>();
		sv.add(new SinhVien("cine"));
		sv.add(new SinhVien("nike"));
		
		List<MonHoc> MH = new ArrayList<MonHoc>();

		
		lopffse.setTenLopHoc("FFSE1702");
		lopffse.setSinhVien(sv);
		System.out.println(lopffse.thongTinLopHoc());


	}

}
