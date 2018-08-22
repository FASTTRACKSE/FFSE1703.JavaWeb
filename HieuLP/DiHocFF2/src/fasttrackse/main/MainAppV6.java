package fasttrackse.main;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.*;

public class MainAppV6 {

	public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		SinhVienVersion5 sinhVien1 = context.getBean("sinhVien1", SinhVienVersion5.class);
		SinhVienVersion5 sinhVien2 = context.getBean("sinhVien1", SinhVienVersion5.class);
		
		MonToan monToan = context.getBean("monToan", MonToan.class);
		MonLy monLy = context.getBean("monLy", MonLy.class);
		English english =  context.getBean("english", English.class);
		
		KhoaNganHan heDaoTaoNganHan = context.getBean("khoaNganHan", KhoaNganHan.class);


		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		monHoc1.add(monToan);
		monHoc1.add(monLy);
		
		List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
		monHoc2.add(english);
		
		sinhVien1.setHoTen("Thành");
		sinhVien1.setMonHoc(monHoc1);
		
		sinhVien2.setHoTen("Hồng");
		sinhVien2.setHeDaoTao(heDaoTaoNganHan);
		sinhVien2.setMonHoc(monHoc2);

		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());
		
		context.close();
	}

}