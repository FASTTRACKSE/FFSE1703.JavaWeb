package fasttrackse.main;



import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.*;

public class MainAppVersion1 {
	
	//public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args ) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		LopHoc lopHoc1 = context.getBean("lopHoc",LopHoc.class);
		LopHoc lopHoc2 = context.getBean("lopHoc",LopHoc.class);
		LopHoc lopHoc3 = context.getBean("lopHoc",LopHoc.class);
		
		NhapMonLapTrinh nhapMonLapTrinh = context.getBean("nhapMonLapTrinh", NhapMonLapTrinh.class);
		MonJavaCore javacore = context.getBean("monJavaCore", MonJavaCore.class);
		MonJavaWeb javaWeb = context.getBean("monJavaWeb", MonJavaWeb.class);
		WebFrontEnd webFrontEnd = context.getBean("webFrontEnd", WebFrontEnd.class);
		
		HocKy1 hocKy1 = context.getBean("hocKy1", HocKy1.class);
		HocKy2 hocKy2 = context.getBean("hocKy2", HocKy2.class);
		
		DaoTaoDaiHan daoTaoDaiHan = context.getBean("daoTaoDaiHan", DaoTaoDaiHan.class);
		DaoTaoNganHan daoTaoNganHan = context.getBean("daoTaoNganHan", DaoTaoNganHan.class);
		
		//khởi tạo danh sách sinh viên của lớp 1701
		List<SinhVien> sv1 = new ArrayList<SinhVien>();
		sv1.add(new SinhVien("Lê Văn Chương"));
		sv1.add(new SinhVien("Lê Văn Chương"));
		sv1.add(new SinhVien("Lê Văn Chương"));
		sv1.add(new SinhVien("Lê Văn Chương"));

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
		sv2.add(new SinhVien("Lê Văn Chương"));
		sv2.add(new SinhVien("Lê Văn Chương"));
		sv2.add(new SinhVien("Lê Văn Chương"));
		sv2.add(new SinhVien("Lê Văn Chương"));
		
		//khởi tạo danh sách môn học có trong học kì 2
		List<MonHoc> mh2 = new ArrayList<MonHoc>();
		mh2.add(nhapMonLapTrinh);
		mh2.add(javaWeb);
		
		lopHoc2.setLopHoc("Lớp FFSE1702");
		lopHoc2.setSinhVien(sv2);
		lopHoc2.setMonHoc(mh2);
		lopHoc2.setDaoTao(daoTaoNganHan);
		lopHoc2.setHocKy(hocKy2);
		
		List<SinhVien> sv3 = new ArrayList<SinhVien>();
		sv3.add(new SinhVien("Chương"));
		sv3.add(new SinhVien("Chương"));
		sv3.add(new SinhVien("Chương"));
		sv3.add(new SinhVien("Chương"));
		
		List<MonHoc> mh3 = new ArrayList<MonHoc>();
		mh3.add(javaWeb);
		mh3.add(webFrontEnd);
		
		lopHoc3.setLopHoc("Lớp FFSe1702");
		lopHoc3.setDaoTao(daoTaoNganHan);
		lopHoc3.setHocKy(hocKy1);
		lopHoc3.setSinhVien(sv3);
		lopHoc3.setMonHoc(mh3);
		
		
		
		System.out.println(lopHoc1.getLop());
		System.out.println(lopHoc2.getLop());
		System.out.println(lopHoc3.getLop());
		context.close();
	}
}