package fasttrackse.main;



import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.*;

public class MainApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		LopHoc lopHoc = context.getBean("lopHoc",LopHoc.class);
		
		JavaCore javacore = context.getBean("javaCore", JavaCore.class);
		JavaWeb javaWeb = context.getBean("javaWeb", JavaWeb.class);
		HocKy1 hocKy1 = context.getBean("hocKy1", HocKy1.class);
		DaoTaoDaiHan daoTaoDaiHan = context.getBean("daoTaoDaiHan", DaoTaoDaiHan.class);
		
		List<SinhVien> sv = new ArrayList<SinhVien>();
		sv.add(new SinhVien("Minh"));
		sv.add(new SinhVien("Minh"));
		sv.add(new SinhVien("Minh"));
		sv.add(new SinhVien("Minh"));
		
		List<MonHoc> mh = new ArrayList<MonHoc>();
		mh.add(javaWeb);
		mh.add(javacore);
		
		lopHoc.setLopHoc("Lớp FFSE1701");
		lopHoc.setSinhVien(sv);
		lopHoc.setMonHoc(mh);
		lopHoc.setDaoTao(daoTaoDaiHan);
		lopHoc.setHocKy(hocKy1);
		
		System.out.println(lopHoc.getLop());
	}
}
