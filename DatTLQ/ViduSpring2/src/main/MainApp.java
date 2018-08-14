package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.DaoTaoDaiHan;
import entity.DaoTaoNganHan;
import entity.MonHoa;
import entity.MonHoc;
import entity.MonLy;
import entity.MonToan;
import entity.SinhVien;

public class MainApp {

	public static void main(String[] args) {
	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	 SinhVien sinhVien = context.getBean("sinhVien", SinhVien.class);
	 SinhVien sinhVien1 = context.getBean("sinhVien", SinhVien.class);

	 MonToan monToan=context.getBean("monToan",MonToan.class);
	 MonLy monLy=context.getBean("monLy",MonLy.class);
	 MonHoa monHoa=context.getBean("monHoa",MonHoa.class);
	 DaoTaoDaiHan daiHan=context.getBean("daoTaoDaiHan", DaoTaoDaiHan.class);
	 DaoTaoNganHan nganHan=context.getBean("daoTaoNganHan", DaoTaoNganHan.class);
	 List<MonHoc> listMonHoc= new ArrayList<>();
	 listMonHoc.add(monToan);
	 listMonHoc.add(monLy);
	 listMonHoc.add(monHoa);
	 
	 sinhVien.setHeDaoTao(daiHan);
	 sinhVien.setMonHoc(listMonHoc);
	 sinhVien.mangSachDiHoc();
	 
	 sinhVien1.setHoTen("Tiên");
	 sinhVien1.setHeDaoTao(nganHan);
	 sinhVien1.setMonHoc(listMonHoc);
	 sinhVien1.mangSachDiHoc();
	
	}

}
