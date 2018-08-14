package main;




import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.GiangVien;
import entity.HeDaiHan;
import entity.HeNganHan;
import entity.HocKi;
import entity.HocKi1;
import entity.HocKi2;
import entity.HocKi3;
import entity.HocKi4;
import entity.HocKiJava;
import entity.LopHoc;
import entity.MonCongNghe;
import entity.MonThucTap;
import entity.MonTiengAnh;
import entity.SinhVien;

public class MainApp {

	private static ClassPathXmlApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		List<SinhVien> listSinhVien = new ArrayList<>();
		listSinhVien.add(new SinhVien("Tuấn","tuan@gmail.com","Quảng Thanh","01645931227"));
		listSinhVien.add(new SinhVien("Minh Tuấn","tuan@gmail.com","Quảng Thanh","01645931227"));
		listSinhVien.add(new SinhVien("Ngô Minh Tuấn","tuan@gmail.com","Quảng Thanh","01645931227"));
		
		MonCongNghe monCongNgheHk1 = context.getBean("monCongNghe",MonCongNghe.class);
		monCongNgheHk1.setTenMonHoc("Nhập Môn Lập trình");
		monCongNgheHk1.setGiangVien(new GiangVien("Thầy Thành2","thanhcl2@gmail.com"));
		monCongNgheHk1.setTroGiang(new GiangVien("Thầy Thắng2","thang2@gnail.com"));
		monCongNgheHk1.setMentor(new GiangVien("anh Tuấn2","tuan2@gmail.com"));
		
		MonCongNghe monCongNgheHk11 = context.getBean("monCongNghe",MonCongNghe.class);
		monCongNgheHk11.setTenMonHoc("HTML/CSS");
		monCongNgheHk11.setGiangVien(new GiangVien("Thầy ThànhCL","thanhcl@gmail.com"));
		monCongNgheHk11.setTroGiang(new GiangVien("Thầy ThắngNT","thang@gnail.com"));
		monCongNgheHk11.setMentor(new GiangVien("anh TuấnNM","tuan@gmail.com"));
		
		MonCongNghe monCongNgheHk2 = context.getBean("monCongNghe",MonCongNghe.class);
		monCongNgheHk2.setTenMonHoc("Lập trình PHP");
		monCongNgheHk2.setGiangVien(new GiangVien("Thầy Thành","thanhcl2@gmail.com"));
		monCongNgheHk2.setTroGiang(new GiangVien("Thầy Thắng","thang2@gnail.com"));
		monCongNgheHk2.setMentor(new GiangVien("anh Tuấn","tuan2@gmail.com"));
		
		MonCongNghe monCongNgheHk21 = context.getBean("monCongNghe",MonCongNghe.class);
		monCongNgheHk21.setTenMonHoc("Lập trình Javacore");
		monCongNgheHk21.setGiangVien(new GiangVien("Thầy ThànhCL","thanhcl@gmail.com"));
		monCongNgheHk21.setTroGiang(new GiangVien("Thầy ThắngNT","thang@gnail.com"));
		monCongNgheHk21.setMentor(new GiangVien("anh TuấnNM","tuan@gmail.com"));
		
		MonCongNghe monCongNgheHk3 = context.getBean("monCongNghe",MonCongNghe.class); 
		monCongNgheHk3.setTenMonHoc("Lập trình Java Web Severlet");
		monCongNgheHk3.setGiangVien(new GiangVien("Thầy ThànhCL","thanhcl@gmail.com"));
		monCongNgheHk3.setTroGiang(new GiangVien("Thầy ThắngNT","thang@gnail.com"));
		monCongNgheHk3.setMentor(new GiangVien("anh TuấnNM","tuan@gmail.com"));
		
		MonCongNghe monCongNgheHk31 = context.getBean("monCongNghe",MonCongNghe.class);
		monCongNgheHk31.setTenMonHoc("Lập trình Java Web JSF");
		monCongNgheHk31.setGiangVien(new GiangVien("Thầy ThànhCL","thanhcl@gmail.com"));
		monCongNgheHk31.setTroGiang(new GiangVien("Thầy ThắngNT","thang@gnail.com"));
		monCongNgheHk31.setMentor(new GiangVien("anh TuấnNM","tuan@gmail.com"));
		
	
		
		MonTiengAnh monTAHK1 = context.getBean("monTiengAnh",MonTiengAnh.class);
		monTAHK1.setTenMonHoc("Tiếng anh cơ sở");
		monTAHK1.setTrinhDo("Level 1");
		monTAHK1.setGiangVien(new GiangVien("cô Hồng","hong@gmail.com"));
		monTAHK1.setTroGiang(new GiangVien("cô Hương","huong@gmail.com"));
		
		MonTiengAnh monTAHk2 = context.getBean("monTiengAnh",MonTiengAnh.class);
		monTAHk2.setTenMonHoc("Tiếng anh chuyên nghành");
		monTAHk2.setTrinhDo("Level 2");
		monTAHk2.setGiangVien(new GiangVien("cô Hồng","hongnt@gmail.com"));
		monTAHk2.setTroGiang(new GiangVien("cô Hương","huonght@gmail.com"));
		
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
		monThucTap.setGiangVien(new GiangVien("Minh Tuấn","ngominhtuan@gmail.com"));
		monThucTap.setNoiThucTap("FPT sotfware");
		
		
		HocKi1 hk1 = context.getBean("hocKi1",HocKi1.class);
		hk1.setListCongNghe(listMonCNHk1);
		hk1.setMonTiengAnh(monTAHK1);
		
		HocKi2 hk2 = context.getBean("hocKi2",HocKi2.class);
		hk2.setListCongNghe(listMonCNHk2);
		hk2.setMonTiengAnh(monTAHk2);
		
		HocKi3 hk3 = context.getBean("hocKi3",HocKi3.class);
		hk3.setListCongNghe(listMonCNHk3);
		
		HocKi4 hk4 = context.getBean("hocKi4",HocKi4.class);
		hk4.setMonThucTap(monThucTap);
		
		
		List<HocKi> listHocKi = new ArrayList<>();
		listHocKi.add(hk1);
		listHocKi.add(hk2);
		listHocKi.add(hk3);
		listHocKi.add(hk4);
		
		HeDaiHan heDaiHan = context.getBean("heDaiHan",HeDaiHan.class);
		heDaiHan.setListHK(listHocKi);
		
		
		
		LopHoc lop = context.getBean("lopHoc",LopHoc.class);
		lop.setTenLop("FFSE1703");
		lop.setHeDaoTao(heDaiHan);
		lop.setListSinhVien(listSinhVien);
		lop.getLopHoc();
		
		List<String> chuDe = new ArrayList<>();
		chuDe.add("Web bán hàng -PHP");
		chuDe.add("Web Giới thiệu sản phẩm -PHP");
		chuDe.add("Web Du lịch -PHP");
		
		
		HocKiJava hkJava = context.getBean("hocKiJava",HocKiJava.class);
		hkJava.setListCongNghe(listMonCNHk1);
		hkJava.setListChuDe(chuDe);
		HeNganHan heNganHan=  context.getBean("heNganHan",HeNganHan.class);
		heNganHan.setHocKi(hkJava);
		
		LopHoc lop1 = context.getBean("lopHoc",LopHoc.class);
		lop1.setTenLop("FFSE1704");
		lop1.setHeDaoTao(heNganHan);
		lop1.setListSinhVien(listSinhVien);
		lop1.getLopHoc();
	}

}
