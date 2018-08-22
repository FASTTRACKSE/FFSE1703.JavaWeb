package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;
import fasttrackse.entity.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {

	private static ClassPathXmlApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		List<SinhVien> listSinhVien = new ArrayList<>();
		listSinhVien.add(new SinhVien("Chương","chuong1999@gmail.com","Quảng Nôm","01668707486"));
		listSinhVien.add(new SinhVien("Chương","chuong1999@gmail.com","Quảng Nôm","01668707486"));
		listSinhVien.add(new SinhVien("Chương","chuong1999@gmail.com","Quảng Nôm","01668707486"));
		
		MonCongNghe monCongNgheHk1 = context.getBean("monCongNghe",MonCongNghe.class);
		monCongNgheHk1.setTenMonHoc("Nhập Môn Lập trình");
		monCongNgheHk1.setGiangVien(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		monCongNgheHk1.setTroGiang(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		monCongNgheHk1.setMentor(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		
		MonCongNghe monCongNgheHk11 = context.getBean("monCongNghe",MonCongNghe.class);
		monCongNgheHk11.setTenMonHoc("HTML/CSS");
		monCongNgheHk11.setGiangVien(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		monCongNgheHk11.setTroGiang(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		monCongNgheHk11.setMentor(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		
		MonCongNghe monCongNgheHk2 = context.getBean("monCongNghe",MonCongNghe.class);
		monCongNgheHk2.setTenMonHoc("Lập trình PHP");
		monCongNgheHk2.setGiangVien(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		monCongNgheHk2.setTroGiang(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		monCongNgheHk2.setMentor(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		
		MonCongNghe monCongNgheHk21 = context.getBean("monCongNghe",MonCongNghe.class);
		monCongNgheHk21.setTenMonHoc("Lập trình JavaCore");
		monCongNgheHk21.setGiangVien(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		monCongNgheHk21.setTroGiang(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		monCongNgheHk21.setMentor(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		
		MonCongNghe monCongNgheHk3 = context.getBean("monCongNghe",MonCongNghe.class); 
		monCongNgheHk3.setTenMonHoc("Lập trình Java Web Severlet");
		monCongNgheHk3.setGiangVien(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		monCongNgheHk3.setTroGiang(new GiangVien("Thầy Chương","chuong1999@gnail.com"));
		monCongNgheHk3.setMentor(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		
		MonCongNghe monCongNgheHk31 = context.getBean("monCongNghe",MonCongNghe.class);
		monCongNgheHk31.setTenMonHoc("Lập trình Java Web JSF");
		monCongNgheHk31.setGiangVien(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		monCongNgheHk31.setTroGiang(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		monCongNgheHk31.setMentor(new GiangVien("Thầy Chương","chuong1999@gmail.com"));
		
	
		
		MonEnglish monTAHK1 = context.getBean("monEnglish",MonEnglish.class);
		monTAHK1.setTenMonHoc("Tiếng anh cơ sở");
		monTAHK1.setTrinhDo("Level 1");
		monTAHK1.setGiangVien(new GiangVien("cô Hồng","hong@gmail.com"));
		monTAHK1.setTroGiang(new GiangVien("cô Hồng","hong@gmail.com"));
		
		MonEnglish monTAHk2 = context.getBean("monEnglish",MonEnglish.class);
		monTAHk2.setTenMonHoc("Tiếng anh chuyên nghành");
		monTAHk2.setTrinhDo("Level 2");
		monTAHk2.setGiangVien(new GiangVien("cô Hồng","hongnt@gmail.com"));
		monTAHk2.setTroGiang(new GiangVien("cô Hồng","hong@gmail.com"));
		
		List<MonCongNghe> listMonCNHk1 = new ArrayList<>();	
		listMonCNHk1.add(monCongNgheHk1);
		listMonCNHk1.add(monCongNgheHk11);
		
		List<MonCongNghe> listMonCNHk2 = new ArrayList<>();	
		listMonCNHk2.add(monCongNgheHk2);
		listMonCNHk2.add(monCongNgheHk21);
		
		List<MonCongNghe> listMonCNHk3 = new ArrayList<>();	
		listMonCNHk3.add(monCongNgheHk3);
		listMonCNHk3.add(monCongNgheHk31);
		
		MonThucTap monThucTap= context.getBean("monThucTap",MonThucTap.class);
		monThucTap.setGiangVien(new GiangVien("Chương","chuong1999@gmail.com"));
		monThucTap.setNoiThucTap("FPT software");
		
		
		HocKi1 hk1 = context.getBean("hocKi1",HocKi1.class);
		hk1.setListCongNghe(listMonCNHk1);
		hk1.setMonEnglish(monTAHK1);
		
		HocKi2 hk2 = context.getBean("hocKi2",HocKi2.class);
		hk2.setListCongNghe(listMonCNHk2);
		hk2.setMonEnglish(monTAHk2);
		
		HocKi3 hk3 = context.getBean("hocKi3",HocKi3.class);
		hk3.setListCongNghe(listMonCNHk3);
		
		HocKi4 hk4 = context.getBean("hocKi4",HocKi4.class);
		hk4.setMonThucTap(monThucTap);
		
		
		List<HocKi> listHocKi = new ArrayList<>();
		listHocKi.add(hk1);
		listHocKi.add(hk2);
		listHocKi.add(hk3);
		listHocKi.add(hk4);
		
		DaoTaoDaiHan daoTaoDaiHan = context.getBean("daoTaoDaiHan",DaoTaoDaiHan.class);
		daoTaoDaiHan.setListHK(listHocKi);
		
		
		
		LopHoc lop = context.getBean("lopHoc",LopHoc.class);
		lop.setTenLopHoc("FFSE1703");
		lop.setHeDaoTao(daoTaoDaiHan);
		lop.setListSinhVien(listSinhVien);
		lop.getTenLopHoc();
		
		List<String> chuDe = new ArrayList<>();
		chuDe.add("WEB ẨM THỰC -PHP");
		chuDe.add("WEB MÔ TẢ VỀ MÓN ĂN  -PHP");
		chuDe.add("WEB DU LỊCH -PHP");
		
		
		HocKiJava hkJava = context.getBean("hocKiJava",HocKiJava.class);
		hkJava.setListCongNghe(listMonCNHk1);
		hkJava.setListChuDe(chuDe);
		DaoTaoNganHan daoTaoNganHan=  context.getBean("daoTaoNganHan",DaoTaoNganHan.class);
		daoTaoNganHan.setListHK(hkJava);
		
		LopHoc lop1 = context.getBean("lopHoc",LopHoc.class);
		lop1.setTenLopHoc("FFSE1704");
		lop1.setHeDaoTao(daoTaoNganHan);
		lop1.setListSinhVien(listSinhVien);
		lop1.getTenLopHoc();
	}

}