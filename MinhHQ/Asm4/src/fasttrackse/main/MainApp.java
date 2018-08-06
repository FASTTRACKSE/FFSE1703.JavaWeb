package fasttrackse.main;



import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.*;

public class MainApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		LopHoc lopHoc1 = context.getBean("lopHoc",LopHoc.class);
		LopHoc lopHoc2 = context.getBean("lopHoc",LopHoc.class);
		
		NhapMonLapTrinh nhapMonLapTrinh = context.getBean("nhapMonLapTrinh", NhapMonLapTrinh.class);
		JavaCore javacore = context.getBean("javaCore", JavaCore.class);
		JavaWeb javaWeb = context.getBean("javaWeb", JavaWeb.class);
		
		HocKy1 hocKy1 = context.getBean("hocKy1", HocKy1.class);
		HocKy2 hocKy2 = context.getBean("hocKy2", HocKy2.class);
		
		DaoTaoDaiHan daoTaoDaiHan = context.getBean("daoTaoDaiHan", DaoTaoDaiHan.class);
		DaoTaoNganHan daoTaoNganHan = context.getBean("daoTaoNganHan", DaoTaoNganHan.class);
		
		//khởi tạo danh sách sinh viên của lớp 1701
		List<SinhVien> sv1 = new ArrayList<SinhVien>();
		sv1.add(new SinhVien("Hồ Quang Minh"));
		sv1.add(new SinhVien("Hồ Viết Tú"));
		sv1.add(new SinhVien("Lê Thanh Danh"));
		sv1.add(new SinhVien("Lê Phước Hiếu"));
//			SinhVien sv = new SinhVien();
//			sv.setHoTen("Hồ Quang Minh");
//			sv1.add(sv);
//			sv.setHoTen("Hồ Viết Tú");
//			sv1.add(sv);
//			sv.setHoTen("Lê Thanh Danh");
//			sv1.add(sv);
//			sv.setHoTen("Lê Phước Hiếu");
//			sv1.add(sv);
		
		//khởi tạo danh sách môn học có trong học kì 1
		List<MonHoc> mh1 = new ArrayList<MonHoc>();
		mh1.add(javaWeb);
		mh1.add(javacore);
		
		//khởi tạo giá trị cho lớp
		lopHoc1.setLopHoc("Lớp FFSE1701");
		lopHoc1.setSinhVien(sv1);
		lopHoc1.setMonHoc(mh1);
		lopHoc1.setDaoTao(daoTaoDaiHan);
		lopHoc1.setHocKy(hocKy1);
		
		//khởi tạo danh sách sinh viên của lớp 1702
		List<SinhVien> sv2 = new ArrayList<SinhVien>();
		sv2.add(new SinhVien("Chung Hải Nam"));
		sv2.add(new SinhVien("Vũ Thị Lan Hương"));
		sv2.add(new SinhVien("Trần Thị Tâm"));
		sv2.add(new SinhVien("Trần Minh Tuấn"));
		
		//khởi tạo danh sách môn học có trong học kì 2
		List<MonHoc> mh2 = new ArrayList<MonHoc>();
		mh2.add(nhapMonLapTrinh);
		mh2.add(javaWeb);
		
		lopHoc2.setLopHoc("Lớp FFSE1702");
		lopHoc2.setSinhVien(sv2);
		lopHoc2.setMonHoc(mh2);
		lopHoc2.setDaoTao(daoTaoNganHan);
		lopHoc2.setHocKy(hocKy2);
		
		
		System.out.println(lopHoc1.getLop());
		System.out.println(lopHoc2.getLop());
		context.close();
	}
}
