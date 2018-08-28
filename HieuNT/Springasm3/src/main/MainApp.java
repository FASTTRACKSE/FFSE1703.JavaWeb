package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import emtity.DaoTaoNganHan;
import emtity.MonHoa;
import emtity.MonHoc;
import emtity.MonLy;
import emtity.MonToan;
import emtity.SinhVienNangCao;

public class MainApp {

	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext1.xml");

		// Tạo bean từ spring containner

		SinhVienNangCao sinhVien1 = context.getBean("sinhVien1", SinhVienNangCao.class);
		SinhVienNangCao sinhVien2 = context.getBean("sinhVien1", SinhVienNangCao.class);


		MonToan monToan = context.getBean("monToan", MonToan.class);
		MonLy monLy = context.getBean("monLy", MonLy.class);
		MonHoa monHoa = context.getBean("monHoa", MonHoa.class);
		DaoTaoNganHan  heDaoTaoNganHan = context.getBean("daoTaoNganHan", DaoTaoNganHan.class);

		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		monHoc1.add(monToan);
		monHoc1.add(monLy);
		monHoc1.add(monHoa);
		
		sinhVien1.setHoTen("HIẾU");
		sinhVien1.setMonHoc(monHoc1);
		
		sinhVien2.setHoTen("MINH");
		sinhVien2.setHeDaoTao(heDaoTaoNganHan);
		sinhVien2.setMonHoc(monHoc1);

		
		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());

	}

}