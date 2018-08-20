package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.DaoTaoNganHan;
import fasttrackse.entity.MonEnglish;
import fasttrackse.entity.MonHoc;
import fasttrackse.entity.MonLy;
import fasttrackse.entity.MonToan;
import fasttrackse.entity.SinhVienVersion5;

public class MainAppSpring {
	
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Tạo bean từ spring containner
		SinhVienVersion5 sinhVien1 = context.getBean("sinhVien1", SinhVienVersion5.class);
		SinhVienVersion5 sinhVien2 = context.getBean("sinhVien1", SinhVienVersion5.class);
		
		MonToan monToan = context.getBean("monToan", MonToan.class);
		MonLy monLy = context.getBean("monLy", MonLy.class);
		MonEnglish monEnglish =  context.getBean("monEnglish", MonEnglish.class);
		
		DaoTaoNganHan  heDaoTaoNganHan = context.getBean("daoTaoNganHan", DaoTaoNganHan.class);


		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		monHoc1.add(monToan);
		monHoc1.add(monLy);
		
		List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
		monHoc2.add(monEnglish);
		
		sinhVien1.setHoTen("Thành");
		sinhVien1.setMonHoc(monHoc1);
		
		sinhVien2.setHoTen("Hồng");
		sinhVien2.setHeDaoTao(heDaoTaoNganHan);
		sinhVien2.setMonHoc(monHoc2);
		
		System.out.println("Nhập tên sinh viên 1:");
		String ten = input.nextLine();
		sinhVien1.setHoTen(ten);
		
		System.out.println("Nhập tên sinh viên 2:");
		String ten1 = input.nextLine();
		sinhVien2.setHoTen(ten1);
		

		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());
		
		context.close();
	}

}